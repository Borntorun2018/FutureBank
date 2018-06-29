import { Component } from '@angular/core';
import { routerTransition } from '../../router.animations';

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
}

