import { Component } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { FileHolder } from 'angular2-image-upload';


//https://aberezkin.github.io/ng2-image-upload/#/readme
//https://www.npmjs.com/package/ng2-fancy-image-uploader
const img = '/assets/images/badboy.jpg';
const URL ='C://uploadedImages'; //Location of images

@Component({
    selector: 'imagezoom-app',
    templateUrl: './imagezoom.component.html',
    styleUrls: ['./imagezoom.component.scss'],
    animations: [routerTransition()]
})
export class ImageZoomComponent {
        
    imageSource = img;
    //uploadedimages: Image[] = [];
    
    
  
    
    showImage(file: FileHolder){
        //console.log("showImage file="+ file.src);
    
    
    }
    
      onUploadFinished(file: FileHolder) {
          //debugger;
          //this.uploadedimages.push(new Image(1,file.src,"temp"));
          this.imageSource= file.src;
       }

      onRemoved(file: FileHolder) {
         console.log("onRemoved "+ file);
      }

      onUploadStateChanged(state: boolean) {
      //console.log("onUploadStateChanged "+ file); 
      }   
    
      onClicked(file: FileHolder) {
        console.log("onClicked "+ file); 
      }   
    
    /**
 class Image {
    id: number;
    src: string;
    name: string;

    constructor(id, src,name){
        this.id = id;
        this.name = name;
        this.src = src;
    }
}
    **/



}
  






