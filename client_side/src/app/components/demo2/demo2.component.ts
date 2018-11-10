
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'my-app',
  templateUrl: './demo2.component.html',
  styleUrls: [ './demo2.component.css' ]
})
export class DemoComponent2 implements OnInit {
  name = 'Angular 4';
  //url = '';
 
    urls: Array<any>= [];
    
   ngOnInit(){
    debugger;
  } 
    
    
  debugger;
  onSelectFile(event) {
        debugger;    
   //Check File API support
    if (event.target.files && event.target.files.length>0 ) {
        
        var files = event.target.files; //FileList object
        var reader;
        for (let file of files) {
            
            //Only pics
            if (!file.type.match('image')) continue;

            reader = new FileReader();
            reader.readAsDataURL(file); // read file as data url

            reader.onload = (event) => { // called once readAsDataURL is completed
              //this.url = event.target.result;
              debugger;  
              this.urls.push(event.target.result);  
            }
            //Read the image
            //picReader.readAsDataURL(file);
        }
    } else {
        console.log("Your browser does not support File API");
    }
}
}    
 