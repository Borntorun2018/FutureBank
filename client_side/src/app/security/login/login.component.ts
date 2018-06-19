import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { LoginService } from './login.service';


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

    constructor(public router: Router, public authenticationService: LoginService) {}

     ngOnInit() {
        // reset login status
        this.authenticationService.logout();
    }

    login() {
        //debugger;
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(result => {
                if (result === true) {
                    // login successful
                    //console.log("Inside login() " + sessionStorage.getItem('isLoggedin')); //sessionStorage localStorage
                    //debugger;
                    this.message="successfully logged in"
                    this.router.navigate(['home']);
                    //this.router.navigate(['not-found']);
                } else {
                    // login failed
                    //debugger;
                    this.error = 'Username or password is incorrect';
                    this.loading = false;
                }
            }, error => {
              //debugger;
              //Error occurred attempting to login to system
              this.loading = false;
              this.error = error.message;
              this.message="Error occurred attempting to login, Please try again";
            });
    }
  
    
}
