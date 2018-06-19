import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { NgxPermissionsService } from 'ngx-permissions';
import { Role } from './../../general/types/role.type';

@Component({
    selector: 'app-about',
    templateUrl: './about.component.html',
    styleUrls: ['./about.component.scss'],
    animations: [routerTransition()]
})
export class AboutComponent implements OnInit {
     
 constructor(private permissionsService : NgxPermissionsService){
   console.log("Inside AppComponent constructor");
   debugger;
   permissionsService.addPermission('ADMIN');
 }  

 ngOnInit(): void{
   this.permissionsService.addPermission('ADMIN');
 }
      
 addAdminPermission() {
   console.log("Inside addAdminPermission setting up ADMIN");
  this.permissionsService.addPermission('ADMIN');
 }
      
 removePermission() {
   console.log("Inside removeAdminPermission remove ADMIN");
   this.permissionsService.removePermission('ADMIN')
 } 
    
}
