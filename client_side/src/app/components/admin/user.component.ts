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
    
    errorMsg: any;
    message: any;
    status: any;
    userDetailsHeading: any;
    isDisabled: boolean= false;;
    
        constructor(private  usersService: UsersService, private route: ActivatedRoute,private location: Location ) {}
         
     ngOnInit() {
        this.loading = true;
        this.message = "Please wait - loading data";
        this.status=this.route.snapshot.params['status'];
         if (this.status==='view')this.userDetailsHeading="View User Details";
         else this.userDetailsHeading="Edit User Details";
         
        this.route.params
        .switchMap((params: Params) => this.usersService.getUser(+params['id']))
        .subscribe((data:any) => {
            debugger;
            this.user = data.users.content[0];
       });
     }
   
  save(): void {
      debugger;
    this.usersService.updateUser(this.user).toPromise()
      .then(() => this.goBack());
  }  
    
    
    
    
  goBack(): void {
    this.location.back();
  }    
}
