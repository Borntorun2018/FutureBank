import { Component, OnInit } from '@angular/core';
@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
    constructor()  {
        //debugger;
        console.log("Inside AppComponent constructor")
    }

    ngOnInit() {
      //debugger;
      console.log("Inside AppComponent ngOnInit")
    }
}
