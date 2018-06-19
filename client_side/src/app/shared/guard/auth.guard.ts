import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { Router } from '@angular/router';
import { LoginService } from './../../security/login/login.service';
import {TokenStorage} from './../../shared/token.storage';

@Injectable()
export class AuthGuard implements CanActivate {
    
    constructor(private router: Router,  private tokenStorage: TokenStorage, private loginService:LoginService) {}
     
    canActivate() {
         if (!this.tokenStorage.isTokenExpired()){
            return true;  //Since the token has not expired allow the guard to give access
        }else{
           console.log("Inside data AuthGuard not logged in, so go to l/login");
           this.router.navigate(['/login']);
           return false;
        }
     }
}

