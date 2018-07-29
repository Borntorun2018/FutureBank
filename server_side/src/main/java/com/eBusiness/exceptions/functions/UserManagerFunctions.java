package com.eBusiness.exceptions.functions;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eBusiness.exceptions.DataAccessException;
import com.eBusiness.exceptions.ThrowingBiConsumer;
import com.eBusiness.exceptions.ThrowingUnaryOperator;
import com.eBusiness.persist.entity.image.Image;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.service.user.UserService;
import com.eBusiness.util.ImageUtil;


@Service
public class UserManagerFunctions {
	
	 public static final Logger log = Logger.getLogger(UserManagerFunctions.class);
	
	 @Autowired
	 UserService userService; 
	 	 
	 //Save new user details to the database
	 //-----------------------------------------
	 public UnaryOperator<User> saveNewUser = ThrowingUnaryOperator.handlingUnaryOperatorWrapper((user) -> userService.updateUser(user), DataAccessException.class);
	 
	 //Generate the user image filename
	 //-------------------------------------
	 public BiFunction<Integer,Image,String> getGeneratedImageFilename = (id,image) -> ImageUtil.getGeneratedImageFilename(id, image); //Returns a generated image filename    (image is in  the loop)
	 
     //Get image from directory	
	 //------------------------
	 //public byte[] getImgFromDirectory(BiFunction<String, String, byte[]> bi, String imageDirectory, String filename){
	 public byte[] getImgFromDirectory(String imageDirectory, String filename){
		 Optional<byte[]> result=ImageManagerFunctions.getImgFromDirectory(imageDirectory, filename);
		 if (result.isPresent()) return  (byte[])result.get();
		 else return new byte[]{};
	 }
	 	 
	 //Save image to directory
	 //-----------------------
	 public GenericManagerFunctions.GenericConsumer<String, String, Image> saveImgToDirectory = (imageDirectory, filename, image) -> ImageUtil.saveImageToDirectory(imageDirectory, filename, image);  
	 
	 
	 //Save the user image (i.e. generated filename and image details) to database
	 //---------------------------------------------------------------------------
	 public  ThrowingBiConsumer<String,Image> saveImgToDataBase = (filename,image) -> saveImageToDataBase(filename,image); 
	 private void saveImageToDataBase(String filename,Image image) throws DataAccessException{
		  log.debug("Inside saveImageToDataBase using image filename:"+filename+ " for userId="+image.getUserId()); 
		  //Gets the user associated with the image
		  User user = userService.findUser(image.getUserId());
		  //Set the generated filename 
		  image.setName(filename);
		  //Add the image details to the user 
		  user.addImage(image);
		  //update the user in the database with the image changes
		  userService.updateUser(user);
		  log.debug("Inside saveImageToDataBase using image filename:"+filename+ " for userID="+image.getUserId()); 
	 }
	 
	 //Delete user image from file directory
	 public BiConsumer<String, String> deleteImgFromDirectory = (imageDirectory,filename) -> ImageUtil.deleteImageFromDirectory(imageDirectory, filename); 
		 
	 //Remove Images from User - This voids ConcurrentModificationException while looping ***IMPORTANT***** 
	 //---------------------------------------------------------------------------------------------------------
	 private  BiConsumer<String, User> removeImagesFromUserObjectAnFileDir = (imageDirectory, user) -> {
		  for(Iterator<Image> itr = user.getImages().iterator(); itr.hasNext();)
		   { 
			  //Remove Image from user object
			  //=============================
		      Image image=itr.next(); 
		      //Remove Image from file structure
		      //================================
		      deleteImgFromDirectory.accept(imageDirectory, image.getName());;
		      //Remove image from iterator
		      itr.remove();   //*****Note due to this call I have not converted this bit of code into Stream and Lambda experessions **
		                      //=======================================================================================================
		      //remove user from image
		      image.setUser(null);
		   }		 
	 };
 
	 
	 //Check if the user has images
	 //--------------------------------
	 private static Predicate<User> hasUserImages(){
		 return user -> ((user.getImages()!=null)&&(user.getImages().size()>0));
	 }
	 
	
	 	 
	 private  GenericManagerFunctions.GenericConsumer <String, User,User> saveImageToUserObjectAndFileDir = (imageDirectory, newUser,curUser) ->{
		 if (hasUserImages().test(newUser)){
			   //Add the new image to the user object
			   //========================================
			   ProcessUserImage processUserImage = image ->{ processImage(imageDirectory, image, curUser); };
			   newUser.getImages().stream().forEach(image ->processUserImage.updateUserImage(image));
		   }		 
	 };
	 	 	 
	 @FunctionalInterface
	 interface ProcessUserImage{
		 public void updateUserImage(Image image);
     }
	 void processImage(String imageDirectory, Image image, User curUser){
		 
         //Add the image to the user object
         //====================================
         image.setUserId(curUser.getId());
         curUser.addImage(image);
         //Add Image to file structure
         //===========================
         saveImgToDirectory.accept(imageDirectory, image.getName(), image);
	 }
	 
	 
	 
	 //Update the current user images
	 //----------------------------------
	 public  GenericManagerFunctions.GenericConsumer<String, User,User> updateUserImages = (imageDirectory, newUser,curUser) -> {
		 
		  //Check if the user images have been changed (i.e. the user has deleted/replaced the current user images)
		  //===============================================================================================================
		  if (newUser.isUserRemovedDisplayedImages()) 
		  {
			 //Check if we currently have old images for this user ref in our database by image filename 
			 if (hasUserImages().test(curUser))
			 {
			   //Remove all of the current user images from
			   //1) user object
			   //2) file structure	 
			   removeImagesFromUserObjectAnFileDir.accept(imageDirectory, curUser);
			 }
		  }
		  
		 //1)Add newly uploaded image  (i.e. images within newUser to curUser), if they are present, otherwise do nothing
		 //2)Save the newly uploaded image to the file structure, if they are present, otherwise do nothing
		 saveImageToUserObjectAndFileDir.accept(imageDirectory, newUser,curUser);
	 };
	
	
}
