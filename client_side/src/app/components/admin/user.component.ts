import { Component, OnInit, Inject, Input } from '@angular/core';
import { Location }                 from '@angular/common';

//import { Router } from '@angular/router';
import { ActivatedRoute, Params }   from '@angular/router';
import { UsersService } from './../../services/admin/users/users.service';
import { User }         from './../../services/admin/users/user';
import { Http ,HttpModule} from '@angular/http';
import 'rxjs/add/operator/switchMap';

@Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.scss'],
    providers: [ UsersService ]
 })
export class UserComponent implements OnInit {
        
    @Input() user: User;
    loading = false;
    
    error: any;
    message: any;
    status: any;
    
        constructor(private  usersService: UsersService, private route: ActivatedRoute,private location: Location ) {}
         
     ngOnInit() {
        this.loading = true;
        this.message = "Please wait - loading data";
         
         this.route.params
        .switchMap((params: Params) => this.usersService.getUser(+params['id']))
        .subscribe(data => {this.user = data.users.content[0];
              
            
/**            
accountNONExpired:1
accountNONLocked:1
age:33
creationDate:1543449600000
creationUser:null
credentialsNONExpired:1
email:"Mary.Harrow@eBusiness.uk"
enabled:1
expiryTime:null
forenames:null
homeTelephoneNo:null
id:1
images:[]
lastPasswordResetDate:1563577200000
mobileTelephoneNo:null
roles:(2) [{…}, {…}]
salary:3456
surname:null
terminationDate:null
token:null
userRemovedDisplayedImages:false
username:"Mary.Harrow@eBusiness.uk"         
 **/           
           
            
                            });
     }
   
  save(): void {
      debugger;
    this.usersService.updateUser(this.user)
      .then(() => this.goBack());
  }  
    
    
    
    
  goBack(): void {
    this.location.back();
  }    
}
