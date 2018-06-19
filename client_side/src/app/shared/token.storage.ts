import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode';

export const USER_AUTHORITY: string      = 'user_authority';
export const USER_EXPIRY_DATE: string    = 'user_expiry_date';
export const USER_NAME: string           = 'user_name';
export const USER_TOKEN: string          = 'user_token';

const TOKEN_KEY = 'AuthToken';

@Injectable()
export class TokenStorage {

 constructor() { }

 public signOut() {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.clear();
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
  
  public getToken(): string {
    return  window.sessionStorage.getItem(USER_TOKEN); 
  }
  public setToken(token :string){
      window.sessionStorage.setItem(USER_TOKEN,token); 
  }
  
  public getUsername(): string {
    return  window.sessionStorage.getItem(USER_NAME); 
  }
  public setUsername(userName :string) {
      window.sessionStorage.setItem(USER_NAME,userName); 
  }
      
  public getUsernameAuthority(): string {
      try{
        let token =  this.getToken();
        let jwtData = token.split('.')[1]
        let decodedJwtJsonData = window.atob(jwtData)
        let decodedJwtData = JSON.parse(decodedJwtJsonData)
        let authority  = decodedJwtData.scopes[0]; 
        return authority;        
      }
      catch(Error){
         return null; 
      }      
  }
  public setUsernameAuthority(authority :string){
      window.sessionStorage.setItem(USER_AUTHORITY,authority); 
  }
}