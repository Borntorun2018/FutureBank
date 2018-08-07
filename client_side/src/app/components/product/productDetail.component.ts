import { Component } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { FileHolder,UploadMetadata} from 'angular2-image-upload';


const img = '/assets/images/badboy.jpg';  //default
const URL ='C://uploadedImages'; //Location of images

@Component({
    selector: 'app-productDetail',
    templateUrl: './productDetail.component.html',
    styleUrls: ['./productDetail.component.scss'],
    animations: [routerTransition()]
})
export class ProductDetailComponent {
        
    dubugger;
    imageSource = img;
    uploadedimages: Image[] = [];
      
    imageUploaded(file: FileHolder) {
         console.log(event);
        this.imageSource=file.src;
        //this.uploadedimages.push(new Image(1,file.src,"temp"));
        //this.file.push(event.file);
        //console.log(this.file);
      }
    
    
    onBeforeUpload = (metadata: UploadMetadata) => {
        debugger;
        
    
      return metadata;
    };
  
    
    showImage(file: FileHolder){
    }
    
      onUploadFinished(file: FileHolder) {
      
          //debugger;
          //this.uploadedimages.push(new Image(1,file.src,"temp"));
          this.imageSource= file.src;
       }

      onRemoved(file: FileHolder) {
          //debugger;
 
    this.imageSource="";
         console.log("onRemoved "+ file);
      }

      onUploadStateChanged(state: boolean) {
       //debugger;   
      console.log("onUploadStateChanged "); 
      }   
    
 }  
 class Image {
    id: number;
    src: string;
    name: string;

    constructor(id, src, name){
        this.id = id;
        this.name = name;
        this.src = src;
    }
}
    




  






