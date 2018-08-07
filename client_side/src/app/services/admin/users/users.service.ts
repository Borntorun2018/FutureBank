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
   constructor(private http: HttpClient) {}
    
  getAllUsers(): Observable<Object> {
       return this.http.get(this.userUrl)
                       .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error ocurred attempting to getAllUsers"));
                            return Observable.throw(err);
              })
  }
   
  getUser(id: number): Observable<User> {
      return this.http.get(this.userUrl+"/"+id)
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to get a user"));
                            return Observable.throw(err);
             })
  }
        
  updateUser(user: User): Observable<User> {
        return this.http.post(this.userUrl, {user: user})
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to update a user"));
                            return Observable.throw(err);
             })
  }
    
    
  deleteUser(id: number): Observable<Object> {
      return this.http.delete(this.userUrl+"/"+id)
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to delete a user"));
                            return Observable.throw(err);
             })
  }   
    
 
}
