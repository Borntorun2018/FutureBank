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
     
 constructor(private permissionsService : NgxPermissionsService, private tokenStorage: TokenStorage){}  

 ngOnInit(): void{}

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
   this.permissionsService.flushPermissions();
 } 
}
