import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageZoomRoutingModule } from './imagezoom-routing.module';
import { ZoomableDirective }   from './zoomable.directive.js';
import { ImageZoomComponent }  from './imagezoom.component';
import { PageHeaderModule } from './../../shared';

import { FormsModule }   from '@angular/forms';
import { ImageUploadModule } from 'angular2-image-upload'


@NgModule({
  imports:      [
    CommonModule,
    ImageZoomRoutingModule,
    PageHeaderModule,
    ImageUploadModule.forRoot(),
    FormsModule
  ],
  declarations: [
    ImageZoomComponent,
    ZoomableDirective
  ],
  bootstrap:    [ ImageZoomComponent ]
})
export class ImageZoomModule { }