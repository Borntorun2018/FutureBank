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
        this.authenticationService.logout();
    }

    login() {
        //debugger;
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(result => {
                if (result === true) {
                    this.message="successfully logged in"
                    this.router.navigate(['home']);
                } else {
                    this.error = 'Username or password is incorrect';
                    this.loading = false;
                }
            }, error => {
              this.loading = false;
              this.error = error.message;
              this.message="Error occurred attempting to login, Please try again";
            });
    }
  
    
}
