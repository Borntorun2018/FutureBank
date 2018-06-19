import { Component, OnInit } from '@angular/core';
import { NgxPermissionsService } from 'ngx-permissions';
import { Role } from './general/types/role.type';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
    
    constructor(private permissionsService : NgxPermissionsService){
        /**
        console.log("Inside AppComponent constructor");
        const adminRole: Role = {
                name: 'admin',
                validationFunction: () => false
        };
        
        const userRole: Role = {
                name: 'user',
                validationFunction: () => true //boolean or Promise<boolean>
        };**/
        permissionsService.addPermission('ADMIN');
      
    }
    
    /**
    constructor()  {
        //debugger;
        console.log("Inside AppComponent constructor")
    }**/

    ngOnInit() {
      //debugger;
       this.permissionsService.addPermission('ADMIN');
      console.log("Inside AppComponent ngOnInit")
    }
}
