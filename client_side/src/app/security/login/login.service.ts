import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {NgxPermissionsService} from 'ngx-permissions'
import {TokenStorage} from '../../shared/token.storage';


@Injectable()
export class LoginService {
  private authUrl = 'http://localhost:8080/login/auth';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  
  constructor(private http: HttpClient, private tokenStorage: TokenStorage, private permissionsService: NgxPermissionsService) {}
       
    login(username: string, password: string): Observable<boolean> {

        return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), {headers: this.headers})
               .map((response: any) => {
                        let token = response.token;
                         if (token) {
                            this.tokenStorage.setToken(token);
                            this.tokenStorage.setUsername(username);
                            debugger;
                            let perms: [any]=[this.tokenStorage.getUsernameAuthority()];
                            console.log("roles="+perms[0].authority);
                            //Setup the perms associated with this user 
                            const perm = [perms[0].authority, "USER_ROLE"];
                            this.permissionsService.loadPermissions(perm);
                            return true;
                        } else {
                            // return false to indicate failed login
                            return false;
                        }
      }) 
  }

  logout() {
    this.tokenStorage.signOut();
  }

}
