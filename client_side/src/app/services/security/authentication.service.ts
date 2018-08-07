import {Injectable, EventEmitter, Input, Output} from '@angular/core'; 

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TokenStorage } from '../../core/token.storage';
import { JwtHelper } from 'angular2-jwt';
import {NgxPermissionsService} from 'ngx-permissions';
import 'rxjs/add/operator/do';
import { Observable } from 'rxjs/Observable';
import { User }         from '../admin/users/user';


@Injectable()
export class AuthenticationService {
   @Output() getLoggedInName: EventEmitter<any> = new EventEmitter();
          
  private loginUrl = 'http://localhost:8080/login/auth';
  private logoutUrl ='http://localhost:8080/logout/auth';
    
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  jwtHelper: JwtHelper = new JwtHelper();

  constructor(
    private http: HttpClient,
    private token: TokenStorage,
    private permissionsService: NgxPermissionsService
  ) { }

     
  login(username: string, password: string): Observable<boolean> {
    const credentials = {username: username, password: password};
     return this.http.post(this.loginUrl, credentials, {headers: this.headers})
          .map((response: any) => {  
               let token = response.token.token;
               if (token) {
                 this.token.saveToken(token);
                 this.getLoggedInName.emit(response.user.forenames); 
                 //window.sessionStorage.setItem("USER",JSON.stringify(response.user));
                 let perms: any=this.token.getUsernameAuthority();
                 for(let i=0; i<perms.length; i++){
                   this.permissionsService.addPermission(perms[i].authority);  
                 }
             return true;
          } else {
            return false;
          }    
            
            
      }); 
   }

    public logout(): Observable<boolean> {
       return this.http.post(this.logoutUrl,{headers: this.headers})
                 .map((response: any) => {
                     this.getLoggedInName.emit('');
                     this.token.signOut();
                     this.permissionsService.flushPermissions();
                     return true;
      }) 
    }
    
  public isAuthenticated(): boolean {
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