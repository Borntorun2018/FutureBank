import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Rx';
import {User} from './user';

@Injectable()
export class LoggedinService {
   //private user : Observable<User>;  
   //private user : User;  
   private user : Observable<User>; 
    
   constructor() {}
    /**
   public curLoggedInUsers(): Observable<User> {
     //this.user= JSON.parse(window.sessionStorage.getItem("USER")) as Observable<User>;
     return this.user;  
  }
    **/
    
   public curLoggedInUsers() : Observable<User> {
    return this.user;
  } 
    
    
  
}
