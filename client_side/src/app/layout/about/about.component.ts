import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { NgxPermissionsService } from 'ngx-permissions';

@Component({
    selector: 'app-about',
    templateUrl: './about.component.html',
    styleUrls: ['./about.component.scss'],
    animations: [routerTransition()]
})
export class AboutComponent implements OnInit {
    
    constructor(private permissionService : NgxPermissionsService){}
      
    ngOnInit(): void{
        const perm = ["ADMIN"];
        this.permissionService.loadPermissions(perm);
    }
      
    addAdminPermission() {
        console.log("Inside addAdminPermission setting up ROLE_ADMIN");
        this.permissionService.loadPermissions(["ADMIN"])
      }
      
      removePermission() {
        console.log("Inside removeAdminPermission remove  ROLE_ADMIN");
        this.permissionService.removePermission("ADMIN")
      } 
    
}
