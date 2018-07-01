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
    
      onUploadFinished(file: FileHolder) {
        console.log(file);
      }

      onRemoved(file: FileHolder) {
        console.log(file);
      }

      onUploadStateChanged(state: boolean) {
        console.log(state);
      }   
    
}

