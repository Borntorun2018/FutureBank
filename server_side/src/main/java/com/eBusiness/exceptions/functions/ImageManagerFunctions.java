package com.eBusiness.exceptions.functions;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import com.eBusiness.persist.entity.image.Image;
import com.eBusiness.util.ImageUtil;

public class ImageManagerFunctions {

     //Generate the image filename
	 //===========================
	 public static BiFunction<Integer,Image,String> getGeneratedImageFilename = (id,image) -> ImageUtil.getGeneratedImageFilename(id, image);        //Returns a generated image filename    (image is in  the loop)
		 
	 //Get image from directory
	 //========================
	 public static Optional<byte[]> getImgFromDirectory(String imageDirectory, String filename){
		 return getImgFromDirectory.apply(imageDirectory, filename);
	 }	
	 private static BiFunction<String, String, Optional> getImgFromDirectory = (imageDirectory,filename) -> {
		 try{
		   return Optional.of(ImageUtil.getImageFromDirectory(imageDirectory, filename));
		 }catch(java.io.IOException  ioe){
			return Optional.empty(); 
		 }
	 };
	 	 
	 //Save image to directory
	 //=======================
	 public static GenericManagerFunctions.GenericConsumer<String, String, Image> saveImgToDirectory = (imageDirectory, filename, image) -> ImageUtil.saveImageToDirectory(imageDirectory, filename, image); 
	 

	 //Delete image from file directory
	 //================================
	 public static BiConsumer<String, String> deleteImgFromDirectory = (imageDirectory,filename) -> ImageUtil.deleteImageFromDirectory(imageDirectory, filename); 
		 
}
