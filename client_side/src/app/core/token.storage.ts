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
      
  public getUsernameAuthority(): string[] {
          try{
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
        //Should be able to get the name from the token
        //return  window.sessionStorage.getItem(USER_NAME); 
        return "Maureen";
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