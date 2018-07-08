import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { Router } from '@angular/router';
import {TokenStorage} from './../../core/token.storage';

@Injectable()
export class BrowserSideAuthGuard implements CanActivate {
       
    constructor(private router: Router,  private tokenStorage: TokenStorage) {}
    canActivate() {
         if (!this.tokenStorage.isTokenExpired()){
            return true; 
        }else{
           this.router.navigate(['/login']);
           return false;
        }
     }
}

