import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { NgxPermissionsService } from 'ngx-permissions';
import {TokenStorage} from './../../core/token.storage';


@Component({
    selector: 'app-about',
    templateUrl: './about.component.html',
    styleUrls: ['./about.component.scss'],
    animations: [routerTransition()]
})
export class AboutComponent implements OnInit {
     
 constructor(private permissionsService : NgxPermissionsService, private tokenStorage: TokenStorage){
   console.log("Inside AppComponent constructor");
   debugger;
   let perms: [any]=[this.tokenStorage.getUsernameAuthority()];
   //const perm = [perms[0].authority];
   this.permissionsService.loadPermissions(perms);
   debugger;
 }  

 ngOnInit(): void{}

 //Temp code below
 addAdminRole() {
   this.permissionsService.addPermission('ROLE_ADMIN');
 }
 addUserRole() {
   this.permissionsService.addPermission('ROLE_USER');
 }
 addBadRole() {
   this.permissionsService.addPermission('ROLE_BAD');
 }
 
 removeRoles() {
   //this.permissionsService.removePermission('ROLE_ADMIN');
   //this.permissionsService.removePermission('ROLE_USER');
   //this.permissionsService.removePermission('ROLE_BAD');
   this.permissionsService.flushPermissions();
   
 } 
    
 
 
 
}
