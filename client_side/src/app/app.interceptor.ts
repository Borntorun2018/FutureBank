import { Injectable } from '@angular/core';
import {HttpInterceptor, HttpRequest, HttpHandler, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent,
HttpResponse, HttpUserEvent, HttpErrorResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import {TokenStorage} from './core/token.storage';
import 'rxjs/add/operator/do';

const TOKEN_HEADER_KEY = 'Authorization';

/**
 * This class is used to automatically add the token to the request, before calling the backend web services
 */
@Injectable()
export class TokenInterceptor  implements HttpInterceptor {

  constructor(private token: TokenStorage, private router: Router) { debugger;}

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any>> {
    let authReq = req;
      debugger
    if (this.token.getToken() != null) {
      debugger;  
      authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + this.token.getToken())});
    }
    return next.handle(authReq).do(
        (err: any) => {
          if (err instanceof HttpErrorResponse) {
            console.log(err);
            console.log('req url :: ' + req.url);
            if (err.status === 401) {
              this.router.navigate(['user']);
            }
          }
        }
      );
  }

}