import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { Router } from '@angular/router';
import { LoggedinServiceTs } from './../../security/loggedin/loggedin.service';

@Injectable()
export class AuthGuard implements CanActivate {
    
    constructor(private router: Router, private loggedinServiceTs:LoggedinServiceTs) {}
    result: string; 
    
    canActivate() {
 
        console.log("Inside AuthGuard constructor " + sessionStorage.getItem('isLoggedin')); //sessionStorage localStorage
        
        //Original code
        if (sessionStorage.getItem('isLoggedin')) { //sessionStorage localStorage
            console.log("Inside data AuthGuard already logged in");
            return true;
        }

        console.log("Inside data AuthGuard not logged in, so go to l/login");
        this.router.navigate(['/login']);
        return false;
    }
}

