import { Component } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { FileHolder,UploadMetadata} from 'angular2-image-upload';


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
    uploadedimages: Image[] = [];
    private fileCounter = 0;
    
    
    onBeforeUpload = (metadata: UploadMetadata) => {
        debugger;
      if (this.fileCounter % 2 === 0) {
        //metadata.abort = true;
      } else {
        // mutate the file or replace it entirely - metadata.file
       // metadata.url = 'http://somewhereelse.com'
      }

      this.fileCounter++;
      return metadata;
    };
  
    
    showImage(file: FileHolder){
        //console.log("showImage file="+ file.src);
    
    
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
    
      onClicked(file: FileHolder) {
        console.log("onClicked "+ file); 
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
    




  






