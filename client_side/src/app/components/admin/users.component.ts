import { Component, ChangeDetectorRef, ChangeDetectionStrategy, OnInit, Inject, Input } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from './../../services/admin/users/users.service';
import { User }         from './../../services/admin/users/user';
import { Http ,HttpModule} from '@angular/http';
import {NgxPaginationModule, PaginationInstance} from 'ngx-pagination'; 

@Component({ 
    selector: 'app-users',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.css'],
    providers: [ UsersService ],
    changeDetection: ChangeDetectionStrategy.OnPush
})

export class UsersComponent implements OnInit {
   @Input('data') meals: string[] = [];
  
    public filter: string   = '';
    public maxSize: number  = 7;
    public key: string      = 'id';  //set default
    public reverse: boolean = false;
    
    public directionLinks: boolean = true;
    public autoHide: boolean = false;
    public responsive: boolean = false;
       
    users: User[];
    loading = false;
    error: any;
    message: any;
    status: any;
       
    sort(key){
      this.key = key;
      this.reverse  = !this.reverse;
      debugger;    
    }
    
    
    constructor(public router: Router, 
                private cd: ChangeDetectorRef,
                public usersService : UsersService) {}
   
    
   ngOnInit() {
         this.loading = true;
         this.message = "Please wait - loading data";
         this.usersService.getAllUsers()
             .subscribe((data:any) => {
                 debugger;
                    this.users= data.users.content;
                    this.status = 'Succes';
                    this.message ='Successful user search';
                    this.cd.markForCheck();
               }, error => {
                   debugger;
                 this.loading = false;
                 this.error = error.message;
                 this.status = 'Error';
                 this.message ='System failure occurred during attempted user search';
                 this.cd.markForCheck();   
              });
     }  
    
        
    public config: PaginationInstance = {
        id: 'advanced',
        itemsPerPage: 10,
        currentPage: 1
    };
    public labels: any = {
        previousLabel: 'Previous',
        nextLabel: 'Next',
        screenReaderPaginationLabel: 'Pagination',
        screenReaderPageLabel: 'page',
        screenReaderCurrentLabel: `You're on page`
    };

    private popped = [];

    onPageChange(number: number) {
        console.log('change to page', number);
        this.config.currentPage = number;
    }

    pushItem() {
        let item = this.popped.pop() || 'A newly-created meal!';
        this.meals.push(item);
    }

    popItem() {
        this.popped.push(this.meals.pop());
    }
    
    public viewUser(user:User):void{
      this.router.navigate(['/user',user.id,'view']);  
    }
    public updateUser(user:User):void{
      this.router.navigate(['/user',user.id,'update']); 
    }
     
 }
