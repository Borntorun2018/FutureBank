import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Headers,RequestOptions, Request, RequestMethod} from '@angular/http';
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'


@Injectable()
export class RegistrationService {
    
  private registrationUrl = 'http://localhost:8080/registration';
    
  constructor(private http: HttpClient) {}
      
  registration(forename: string, surname: string): Observable<Object> {
      return this.http.post(this.registrationUrl, JSON.stringify({forename: forename, surname: surname}))
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to register"));
                            return Observable.throw(err);
             })
  }  
}
