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
         urls: Array<any>= [];
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
      /**
          file: File(143329) {name: "used-Wilson-juice5 dd-Tennis-racket-25_942_14-Feb-2016.png", 
                              lastModified: 1455474060350, 
                              lastModifiedDate: Sun Feb 14 2016 18:21:00 GMT+0000 (Greenwich Mean Time), 
                              webkitRelativePath: "", 
                              size: 143329, 
                              pending: false
                              src: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAaIA"

          **/
            debugger;
            var reader = new FileReader();
            console.log("file name:"+ file.file.name);
            console.log("file src:"+ file.src);
            reader.readAsDataURL(file.file);
           reader.onload = (event) => { 
              this.urls.push(event.target.result);  
            }
           this.imageSource= file.src;
       }

      onRemoved(file: FileHolder) {
          debugger;
        this.imageSource="";
        console.log("onRemoved "+ file);
      }
      onUploadStateChanged(state: boolean) {
          debugger;
        console.log("onUploadStateChanged "); 
      }   
    
    disableSendButton(Event){
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
    




  






