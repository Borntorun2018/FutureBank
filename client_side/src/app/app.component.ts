import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
        
    constructor() {
        document.body.style.background = 'rgb(26, 26, 26)';
    }

  title = 'app';
}