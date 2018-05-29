import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Headers,RequestOptions, Request, RequestMethod} from '@angular/http';
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'


@Injectable()
export class LoginService {
  private authUrl = 'http://localhost:8080/login/auth';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  public token: string;
   
  constructor(private http: HttpClient) {}
         
    login(username: string, password: string): Observable<boolean> {
        //debugger;
        return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), {headers: this.headers})
               .map((response: any) => {
//debugger;
                         let token = response.token;
                         if (token) {
                            // set token property
                            this.token = token;
                           // store username and jwt token in local storage to keep user logged in between page refreshes
                            sessionStorage.setItem('isLoggedin', JSON.stringify({ username: username, token: token })); 

                            // return true to indicate successful login
                            return true;
                        } else {
//debugger;
                            // return false to indicate failed login
                            return false;
                        }
      }) 
        
        
        
        
  }

    logout() {
        // clear token remove user from local storage to log user out
        this.token = null;
        sessionStorage.removeItem('isLoggedin'); 
    }
 

}
