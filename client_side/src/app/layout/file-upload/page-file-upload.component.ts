import { Component } from '@angular/core';
//import { FileUploadService } from './file-upload.service';
import { FileHolder } from 'angular2-image-upload';

@Component({
  selector: 'page-file-upload',
  templateUrl: './page-file-upload.component.html',
  styleUrls: ['./page-file-upload.component.css']
})
export class PageFileUploadComponent {
    
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
