import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Headers,RequestOptions, Request, RequestMethod} from '@angular/http';
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'


import { User }         from './user';
@Injectable()
export class UsersService {
    
  private userUrl = 'http://localhost:8080/user';
  //private headers = new HttpHeaders({'Content-Type': 'application/json'});
    
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
   
  getUser(id: number): Observable<User> {
      debugger;
      return this.http.get(this.userUrl+"/"+id)
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to get a user"));
                            return Observable.throw(err);
             })
  }
        
  updateUser(user: User): Observable<User> {
      debugger;
      return this.http.put(this.userUrl, JSON.stringify({user: user}))
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to update a user"));
                            return Observable.throw(err);
             })
  }
    
    
  deleteUser(id: number): Observable<Object> {
      debugger;
      return this.http.delete(this.userUrl+"/"+id)
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to delete a user"));
                            return Observable.throw(err);
             })
  }   
    
 
}
