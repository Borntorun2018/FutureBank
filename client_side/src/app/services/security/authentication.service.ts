import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorage } from '../../core/token.storage';
import { JwtHelper } from 'angular2-jwt';
import {NgxPermissionsService} from 'ngx-permissions';
import 'rxjs/add/operator/do';
import { Observable } from 'rxjs/Observable';
//import { HttpRequest } from './request';
//import { HttpEvent } from './response';


@Injectable()
export class AuthenticationService {

  //private authUrl = '/api/login';
  private authUrl = 'http://localhost:8080/login/auth';
  
  
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  jwtHelper: JwtHelper = new JwtHelper();

  constructor(
    private http: HttpClient,
    private token: TokenStorage,
    private permissionsService: NgxPermissionsService
  ) { }

  login(username: string, password: string): Observable<boolean> {
    const credentials = {username: username, password: password};
      
      
    return this.http.post(this.authUrl, credentials, {headers: this.headers})
         //.do(response => { 
         .map((response: any) => {  
          let token = response.token;
          if (token) {
                this.token.saveToken(token);
                let perms: [any]=[this.token.getUsernameAuthority()];
                const perm = [perms[0].authority];
                this.permissionsService.loadPermissions(perms);
            return true;
          } else {
            return false;
          }    
            
            
      }); 
   }

     //Spring security will handle the backen logout
  public logout(): Observable<boolean> {
      return this.http.post(this.authUrl,{headers: this.headers})
                 .map((response: any) => {
                     this.token.signOut();
                     return true;
      }) 
    }
    
  public isAuthenticated(): boolean {
    // console.log('token', this.jwtHelper.decodeToken(this.token.getToken()));
    if(this.token.getToken()==null)
      return false;
    else
      return !this.jwtHelper.isTokenExpired(this.token.getToken());
  }

  
 
  public getUserDetails() {
    if(this.isAuthenticated()){
      return this.jwtHelper.decodeToken(this.token.getToken())
    }
  }

}