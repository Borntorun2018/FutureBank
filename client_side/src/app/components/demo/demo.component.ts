import { Component, OnInit } from '@angular/core';
import { FileService } from '../../services/fileupload/file.service';

@Component({
  selector: 'demo-root',
  templateUrl: './demo.component.html'
 
})
export class DemoComponent implements OnInit {
  title = 'Image Gallery';
  errorMessage: string;
  images: Array<any>= [];
    
ngOnInit(){
    
  }
    
  onFileChanged(event: any) {
    this.images = event.target.files;
      debugger;
    console.log(this.images)
  }
  
  onUpload() {
    const formData = new FormData;
    for (let image of this.images) {
      console.log('gdsgsfsd')
        formData.append('hihi', image.name);
    }
    console.log('gdsgsfsd',formData)
  }   
        
    /**
  constructor(private fileService: FileService) { }

    
    
  ngOnInit(){
    this.getImageData();
  }
    
    
  getImageData(){
    this.fileService.getImages().subscribe(
      
      data =>{ this.images = data.result},
      error => this.errorMessage = error
    )
  }

  refreshImages(status){
        if (status == true){
          console.log( "Uploaded successfully!");
          this.getImageData();
        }
   }
    **/
}
