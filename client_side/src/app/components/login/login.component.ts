import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { AuthenticationService } from './../../services/security/authentication.service';


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {
    model: any = {};
    loading = false;
    error: any;
    message: any
    status: any;

    constructor(public router: Router, public authenticationService: AuthenticationService) {}

     ngOnInit() {
        this.authenticationService.logout();
    }

    login() {
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(result => {
                if (result === true) {
                    this.message="Successfully logged in"
                    this.status = 'Succes';   
                    this.router.navigate(['home']);
                } else {
                    this.message = 'Username or password is incorrect';
                    this.loading = false;
                    this.error='';
                    this.status  = 'Error'; 
                }
            }, error => {
              this.loading = false;
              this.error = error.message;
              this.message="Error occurred attempting to login, Please try again";
              this.status  = 'Error'; 
            });
    }
  
    
}
