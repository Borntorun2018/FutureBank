import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from './users.service';
import { User } from './../user/user';
import { Http ,HttpModule} from '@angular/http';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-users',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.scss'],
    animations: [routerTransition()]
})
export class UsersComponent implements OnInit {
    users: User[];
    loading = false;
    error: any;
    message: any;
    
    currentPage: any;
    
 
    key: string = 'ID'; //set default
    reverse: boolean = false;
    p: number = 1;
    
     constructor(public router: Router, public usersService : UsersService) {}
     ngOnInit() {
          this.loading = true;
         this.message = "Please wait - loading data";
         this.usersService.allUsers()
             .subscribe(users => {
                 this.users=<User[]>users;
                console.log('user details: ' + this.users[0].username);
              }, error => {
                 this.loading = false;
                 this.error = error;
              });
     }
          
     public sort(key){
         this.key = key;
         this.reverse = !this.reverse;
     }
     public setPage(pageNo:number):void {
         this.currentPage = pageNo;    
     }
     public pageChanged(event:any):void {
       //this method will trigger every page click 
       console.log('Number items per page: ' + event.itemsPerPage);
     }
     public viewUser(id:any):void{
         console.log('Inside viewUser id: ' + id);
     }
     public editUser(id:any):void{
         console.log('Inside editUser id: ' + id);
     }
     
}
