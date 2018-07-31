import { Injectable } from '@angular/core';
@Injectable()
export class User {
    constructor(
              
        public id:       number, 
        public username: string, 
        public password: string,
        public salary:   number,
        public age:      number
       
        ){}
}