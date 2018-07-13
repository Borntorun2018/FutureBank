import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Headers,RequestOptions, Request, RequestMethod} from '@angular/http';
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'


@Injectable()
export class UsersService {
    
  private userUrl = 'http://localhost:8080/user';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
    
  constructor(private http: HttpClient) {}
    
  getAllUsers(): Observable<Object> {
      debugger;
       return this.http.get(this.userUrl)
                       .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error ocurred attempting to getAllUsers"));
                            return Observable.throw(err);
              })
  }
    
  getUser(username: string): Observable<Object> {
      debugger;
      return this.http.post(this.userUrl, JSON.stringify({username: username}), {headers: this.headers})
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to getUser"));
                            return Observable.throw(err);
             })
  }
 
}
