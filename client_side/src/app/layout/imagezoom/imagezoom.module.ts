import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageZoomRoutingModule } from './imagezoom-routing.module';
import { ZoomableDirective }   from './zoomable.directive.js';
import { ImageZoomComponent }  from './imagezoom.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
  imports:      [
    CommonModule,
    ImageZoomRoutingModule,
    PageHeaderModule
  ],
  declarations: [
    ImageZoomComponent,
    ZoomableDirective
  ],
  bootstrap:    [ ImageZoomComponent ]
})
export class ImageZoomModule { }