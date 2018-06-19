import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Headers,RequestOptions, Request, RequestMethod} from '@angular/http';
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'


@Injectable()
export class UsersService {
    
  private authUrl = 'http://localhost:8080/user';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  public token: string;
  public username: string;
    
  constructor(private http: HttpClient) {}
    
  allUsers(): Observable<Object> {
      //debugger;
       let currentuser = JSON.parse(sessionStorage.getItem('isLoggedin')); 
       
       if (currentuser!=null){
           this.username = currentuser.username;
           this.token = currentuser.token;
       }
      
       this.headers = new HttpHeaders({ 'Authorization': 'Bearer ' + this.token });
      //debugger;
       console.log("Inside UsersService before call to this.http.get(this.authUrl,{headers: this.headers})  this.token="+this.token);
       return this.http.get(this.authUrl,{headers: this.headers})
       .map((response: Response) => response)
       .catch((err: Response) => {
          console.log((err.statusText || "Can't join the server."));
           return Observable.throw(err);
        })
  }

}
