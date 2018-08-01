import { Injectable } from '@angular/core';
@Injectable()
export class User {
    constructor(
              
        public id:          number, 
        public title:       string,
        public username:    string, 
        public forenames:   string,
        public surname:     string,
        public password:    string,
        public salary:      number,
        public age:         number,
        public gender:      string,
        public homePhoneNo:  string,
        public mobilePhoneNo: string,
        public dob: string,
        public token: string,
        public expiryTime: Date,
        public email:    string, 
        public fullAddress:    string, 
        public addressLine1:    string, 
        public addressLine2:    string, 
        public addressLine3:    string, 
        public addressCounty:    string, 
        public addressCity:    string, 
        public addressPostCode:    string, 
        public addressCountry:    string, 
        public fullDeliveryAddress:    string, 
        public deliveryAddressLine1:    string, 
        public deliveryAddressLine2:    string, 
        public deliveryAddressLine3:    string, 
        public deliveryAddressCounty:    string, 
        public deliveryAddressCity:    string, 
        public deliveryAddressPostCode:    string, 
        public deliveryAddressCountry:    string, 
        public enabled:               number,
        public accountEnabled:        string,

        public accountNONLocked:      number,
        public accountNONExpired:      number,
        public credentialsNONExpired:      number,
        public creationUser:    string, 
       
        public creationDate: Date,
        public terminationDate: Date,
        public lastPasswordResetDate: Date,
        
        public member: string,   
        
        public userRemovedDisplayedImages: boolean
        
          
        ){}
}