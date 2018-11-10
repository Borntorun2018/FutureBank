import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'my-demo3',
  templateUrl: './demo3.component.html'
})
export class DemoComponent3 implements OnInit{
  imageSource; 
  urls: Array<any>= [];

  ngOnInit(){} 
    
  changeImage(no:any) {
   this.imageSource=this.urls[no];
  }

  onSelectFile(event) {
     if (event.target.files && event.target.files.length>0 ) {
        var files = event.target.files; 
        var reader;
        for (let file of files) {
           if (!file.type.match('image')) continue;
            reader = new FileReader();
            reader.readAsDataURL(file); 
            reader.onload = (event) => { 
              this.urls.push(event.target.result); 
              this.imageSource=event.target.result;   
            }
        }
    } else {
        console.log("Your browser does not support File API");
    }
  }    
} 
