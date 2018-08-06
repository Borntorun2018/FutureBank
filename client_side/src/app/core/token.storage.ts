import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode';


const TOKEN_KEY = 'AuthToken';
export const USER_AUTHORITY: string      = 'user_authority';

@Injectable()
export class TokenStorage {

  constructor() { }

  signOut() {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY,  token);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }
     
 //   JWTAuth::toUser(your_token_here);
    
  

 private urlBase64Decode(str: string) {
   let output = str.replace(/-/g, '+').replace(/_/g, '/');
   switch (output.length % 4) {
               case 0: { break; }
               case 2: { output += '=='; break; }
               case 3: { output += '='; break; }
               default: {
                   throw 'Illegal base64url string!';
               }
    }
   return decodeURIComponent(encodeURI (window.atob(output)));
 }   
 public decodeToken(token: string) {
     //debugger;
            let parts = token.split('.');
            if (parts.length !== 3) {
                throw new Error('JWT must have 3 parts');
            }
            let decoded = this.urlBase64Decode(parts[1]);
            if (!decoded) {
                throw new Error('Cannot decode the token');
            }
            return JSON.parse(decoded);
 }   
   /**  
  public getUserInfo() {
  let token = this.getToken();
  let payload;
  if (token) {
    payload = token.split(".")[1];
    payload = window.atob(payload);
    return JSON.parse(payload);
  } else {
    return null;
  }
} **/
    
  
    
  public getUsernameAuthority(): string[] {
          try{
             // debugger;
            let token =  this.getToken();
            let jwtData = token.split('.')[1]
            let decodedJwtJsonData = window.atob(jwtData)
            let decodedJwtData = JSON.parse(decodedJwtJsonData)
            return decodedJwtData.scopes;
          }
          catch(Error){
             return null; 
          }      
      }
  
   public setUsernameAuthority(authority :string){
          window.sessionStorage.setItem(USER_AUTHORITY,authority); 
   }



    public getUsername(): string {
       // debugger;
       //var obj =this.getUserInfo();
        return "";
    }
       public isTokenExpired(): boolean {
        try{
            if (this.getTokenExpirationDate(this.getToken())==null) return true; //token expired
            //Set todays date
            var dateNow = new Date();
            //Check if token date is less than now date
            if(this.getTokenExpirationDate(this.getToken()).getTime() < dateNow.getTime()) return true; //token expired
            else return false;  //token not expired
          }
          catch(Error){
            return true;  //token expired
          }
      }
    private getTokenExpirationDate(token:string): Date {
        var decoded=null;
        try{
          decoded = jwt_decode(token);
        }catch(err){
            return null;
        }
        if (decoded.exp === undefined) return null;
        const date = new Date(0); 
        date.setUTCSeconds(decoded.exp);
        return date;
    }



    
}