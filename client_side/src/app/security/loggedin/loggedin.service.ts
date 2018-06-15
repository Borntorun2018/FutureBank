import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import {User} from './../../admin/user/user';
import { LoginService } from './../login/login.service';

@Injectable()
export class LoggedinService {
  private authUrl = 'http://localhost:8080/login/currentUser';
  constructor(private http: HttpClient, private loginService: LoginService) {}
  
  
  curloggedinuser(): Observable<User> {
      debugger;
      let httpHeaders = new HttpHeaders().set('Accept', 'application/json');
      return this.http.get<User>(this.authUrl, {headers: httpHeaders,responseType: 'json'});
  }
  
}
