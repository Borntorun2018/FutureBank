import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageFileUploadRoutingModule } from './file-upload-routing.module';
import { PageFileUploadComponent }     from './page-file-upload.component';

import { PageHeaderModule } from './../../shared';

import { FormsModule }   from '@angular/forms';
import { ImageUploadModule } from 'angular2-image-upload'


@NgModule({
  imports:      [
    CommonModule,
    PageFileUploadRoutingModule,
    PageHeaderModule,
    ImageUploadModule.forRoot(),
    FormsModule
  ],
  declarations: [
    PageFileUploadComponent
  ],
  bootstrap:    [ PageFileUploadComponent ]
})
export class PageFileUploadModule { }