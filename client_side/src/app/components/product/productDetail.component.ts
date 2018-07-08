import { Component } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { FileHolder,UploadMetadata} from 'angular2-image-upload';


//https://aberezkin.github.io/ng2-image-upload/#/readme
//https://www.npmjs.com/package/ng2-fancy-image-uploader
const img = '/assets/images/badboy.jpg';
const URL ='C://uploadedImages'; //Location of images

@Component({
    selector: 'app-productDetail',
    templateUrl: './productDetail.component.html',
    styleUrls: ['./productDetail.component.scss'],
    animations: [routerTransition()]
})
export class ProductDetailComponent {
        
    imageSource = img;
    uploadedimages: Image[] = [];
      
    
    imageUploaded(event:any) {
        debugger;
        console.log(event);
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
    
      //onUploadFinished(file: FileHolder) {
       onUploadFinished(event:any) {  
          debugger;
          //this.uploadedimages.push(new Image(1,file.src,"temp"));
          //this.imageSource= file.src;
       }

      onRemoved(file: FileHolder) {
          debugger;
    /**
     https://segmentfault.com/a/1190000008761862
     console.log(event);
    let index = this.file.indexOf(event.file);
    if( index > -1) {
      this.file.splice(index, 1);
    }
    console.log(this.file);
    
    **/
    
         console.log("onRemoved "+ file);
      }

      onUploadStateChanged(state: boolean) {
       debugger;   
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
    




  






