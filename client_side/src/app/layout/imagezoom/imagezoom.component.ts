import { Component } from '@angular/core';

import { routerTransition } from '../../router.animations';
const img1 = '/assets/images/thumbnail.jpg';
const img2 = '/assets/images/thumbnail2.jpg';

//const img1 = './../../assets/thumbnail.jpg';
//const img2 = 'thumbnail2.jpg';


@Component({
    selector: 'imagezoom-app',
    templateUrl: './imagezoom.component.html',
    styleUrls: ['./imagezoom.component.scss'],
    animations: [routerTransition()]
})
export class ImageZoomComponent {
  imageSource1 = img1;
  imageSource2 = img2;
}
