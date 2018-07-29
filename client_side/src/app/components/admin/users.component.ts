import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from './../../services/admin/users/users.service';
import { User }         from './../../services/admin/users/user';
import { Http ,HttpModule} from '@angular/http';
//import { routerTransition } from './../../router.animations';

@Component({
    selector: 'app-users',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.scss'],
    providers: [ UsersService ]
})
export class UsersComponent implements OnInit {
        
    users: User[];
     
    loading = false;
    
    error: any;
    message: any;
    status: any;
    
    currentPage: any;
     
    key: string = 'ID'; 
    
    reverse: boolean = false;
    
    p: number = 1;  //not sure if this is used
    
     constructor(public router: Router, 
                 public usersService : UsersService) {}
     ngOnInit() {
          this.loading = true;
         this.message = "Please wait - loading data";
         this.usersService.getAllUsers()
             .subscribe((data:any) => {
                 debugger;
                 console.log(data);
                    this.users= data.users.content;
                    this.status == 'Succes';
               }, error => {
                  debugger;
                 this.loading = false;
                 this.error = error.message;
                 this.status == 'Error';
                 
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
     
    
    
    public viewUser(user:User):void{
      let link = ['/user', user.id];
      this.router.navigate(link);
    }
    
    
    
    /**
     public viewUser(user:User):void{
         this.usersService.getUser(user.id)
             .subscribe((data:any) => {
                 debugger;
                 console.log(data);
                    //this.users= data.user;
                 
                    let link = ['/detail', hero.id];
                    this.router.navigate(link);
                 
                    this.status == 'Succes';
               }, error => {
                  debugger;
                 this.loading = false;
                 this.error = error.message;
                 this.status == 'Error';
                 
              });       
          debugger;
         console.log('Inside viewUser id: ' + user.id);
     }
    **/
    
    
     public updateUser(user:User):void{
         debugger;
         console.log('Inside edit User id: ' + user.id);
         
         this.usersService.updateUser(user)
             .subscribe((data:any) => {
                 debugger;
                 console.log(data);
                    this.users= data.user;
                    this.status == 'Succes';
               }, error => {
                  debugger;
                 this.loading = false;
                 this.error = error.message;
                 this.status == 'Error';
                 
              });              
     }
    
      public deleteUser(user:User):void{
         debugger;
         console.log('Inside deletUser id: ' + user.id);
         
         this.usersService.deleteUser(user.id)
             .subscribe((data:any) => {
                 debugger;
                 console.log(data);
                    this.users= data.user;
                    this.status == 'Succes';
               }, error => {
                  debugger;
                 this.loading = false;
                 this.error = error.message;
                 this.status == 'Error';
                 
              });                   
     }
     
}
