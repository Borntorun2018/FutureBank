import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ZoomableDirective }   from './zoomable.directive.js';
import { ImageZoomComponent }  from './imagezoom.component';

@NgModule({
  imports:      [
    BrowserModule
  ],
  declarations: [
    ImageZoomComponent,
    ZoomableDirective
  ],
  bootstrap:    [ ImageZoomComponent ]
})
export class ImageZoomModule { }
