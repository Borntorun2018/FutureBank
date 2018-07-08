import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../../router.animations';
import { AuthenticationService } from './../../services/security/authentication.service';



@Component({
    selector: 'app-logout',
    templateUrl: './logout.component.html',
    styleUrls: ['./logout.component.scss'],
    animations: [routerTransition()]
})
export class LogoutComponent implements OnInit {
    model: any = {};  
    loading = false;
    error: any;
    message: any

    constructor(public router: Router, public authenticationService: AuthenticationService) {}

     ngOnInit() {
        this.authenticationService.logout();
    }

    logout() {
        //debugger;
        this.loading = true;
        this.authenticationService.logout()
            .subscribe(result => {
                if (result === true) {
                    this.message="successfully logged out"
                    this.router.navigate(['home']);
                } else {
                    this.error = 'Unsucessfully logged out';
                    this.loading = false;
                }
            }, error => {
              this.loading = false;
              this.error = error.message;
              this.message="Error occurred attempting to logged out, Please try again";
            });
    }
  
    
}
