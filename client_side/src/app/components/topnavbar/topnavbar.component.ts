import { Component, OnInit, Input } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPermissionsService } from 'ngx-permissions';
import {TokenStorage} from './../../core/token.storage';
import { Observable } from 'rxjs/Observable';
import { User }         from '../../services/admin/users/user';
import { LoggedinService }         from '../../services/admin/users/usersloggedin.service';



@Component({
    selector: 'app-navbar',
    templateUrl: './topnavbar.component.html',
    styleUrls: ['./topnavbar.component.scss']
})
export class TopNavBarComponent implements OnInit {
    
    pushRightClass: string = 'push-right';
    username: string = "anonymous";
    user: Observable<User>;
    
   //@Input() user: User;

    loading = true;
    constructor(private permissionsService : NgxPermissionsService,
                private translate: TranslateService, 
                private loggedinService: LoggedinService,
                private tokenStorage: TokenStorage,
                public router: Router) {
        //debugger;
        let perms: [any]=[this.tokenStorage.getUsernameAuthority()];
        this.permissionsService.loadPermissions(perms);
        //debugger;
        //debugger;
        let currentuser =  window.sessionStorage.getItem("USER_NAME"); 
        //this.user= window.sessionStorage.getItem("USER");
        //this.user=JSON.parse(window.sessionStorage.getItem("USER")) as User;
        
        
        if (currentuser == null) {
          this.username = "anonymous";
         }
  this.user=this.loggedinService.curLoggedInUsers(); 
        this.translate.addLangs(['en', 'fr', 'ur', 'es', 'it', 'fa', 'de', 'zh-CHS']);
        this.translate.setDefaultLang('en');
        const browserLang = this.translate.getBrowserLang();
        this.translate.use(browserLang.match(/en|fr|ur|es|it|fa|de|zh-CHS/) ? browserLang : 'en');

        this.router.events.subscribe(val => {
            if (
                val instanceof NavigationEnd &&
                window.innerWidth <= 992 &&
                this.isToggled()
            ) {
                this.toggleSidebar();
            }
        });
        
    }

    ngOnInit() { 
       this.username = window.sessionStorage.getItem("USER_NAME"); 
      // this.loggedinService.curLoggedInUsers().map(({ user }) => this.user);
      this.user=this.loggedinService.curLoggedInUsers(); 
    
    }
            
    ngAfterViewInit() {
     this.username = window.sessionStorage.getItem("USER_NAME"); 
     this.user=this.loggedinService.curLoggedInUsers();   
    }
    
  
       
    isToggled(): boolean {
         this.username = window.sessionStorage.getItem("USER_NAME"); 
        this.user=this.loggedinService.curLoggedInUsers(); 
         const dom: Element = document.querySelector('body');
        return dom.classList.contains(this.pushRightClass);
    }

    toggleSidebar() {
         this.username = window.sessionStorage.getItem("USER_NAME");   
         this.user=this.loggedinService.curLoggedInUsers(); 
        const dom: any = document.querySelector('body');
        dom.classList.toggle(this.pushRightClass);
    }

    rltAndLtr() {
         this.username = window.sessionStorage.getItem("USER_NAME");   
         this.user=this.loggedinService.curLoggedInUsers(); 
        const dom: any = document.querySelector('body');
        dom.classList.toggle('rtl');
    }

    onLoggedout() {
         sessionStorage.removeItem('isLoggedin'); 
        this.username = "anonymous";
    }

    changeLang(language: string) {
        this.translate.use(language);
    }
}
