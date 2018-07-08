import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Headers,RequestOptions, Request, RequestMethod} from '@angular/http';
import { HttpModule } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'


@Injectable()
export class ProductsService {
    
  private productUrl = 'http://localhost:8080/product';

  constructor(private http: HttpClient) {}
    
  getAllProducts(): Observable<Object> {
    return this.http.get(this.productUrl)
       .map((response: Response) => response)
       .catch((err: Response) => {
          console.log((err.statusText || "Error attempting to return all products"));
           return Observable.throw(err);
        })
  }
    
  getProduct(productId: string): Observable<Object> {
      return this.http.post(this.productUrl, JSON.stringify({productId: productId}))
                        .map((response: Response) => response)
                       .catch((err: Response) => {
                            console.log((err.statusText || "Error occurred attempting to getProduct"));
                            return Observable.throw(err);
             })
  }  

  
  
}
