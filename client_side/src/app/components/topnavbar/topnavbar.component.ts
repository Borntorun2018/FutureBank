import { Component, OnInit, Input } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPermissionsService } from 'ngx-permissions';
import {TokenStorage} from './../../core/token.storage';
import { Observable } from 'rxjs/Observable';
import { AuthenticationService }         from '../../services/security/authentication.service';


@Component({
    selector: 'app-navbar',
    templateUrl: './topnavbar.component.html',
    styleUrls: ['./topnavbar.component.scss']
})
export class TopNavBarComponent implements OnInit {
    
    pushRightClass: string = 'push-right';
    username: string = "anonymous";
  
    loading = true;
    constructor(private permissionsService : NgxPermissionsService,
                private translate: TranslateService, 
                private authenticationService: AuthenticationService,
                 private tokenStorage: TokenStorage,
                public router: Router) {
        
         let perms: [any]=[this.tokenStorage.getUsernameAuthority()];
         this.permissionsService.loadPermissions(perms);
         
         let currentuser =  window.sessionStorage.getItem("USER_NAME"); 
         if (currentuser == null) {
          this.username = "anonymous";
         }
        
         authenticationService.getLoggedInName.subscribe(name => this.changeName(name));
        
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
    
    private changeName(name: string): void {
      this.username = name;
    }
    
    ngOnInit() { 
    }
            
    ngAfterViewInit() {
    }
    
  
       
    isToggled(): boolean {
         const dom: Element = document.querySelector('body');
        return dom.classList.contains(this.pushRightClass);
    }

    toggleSidebar() {
      const dom: any = document.querySelector('body');
      dom.classList.toggle(this.pushRightClass);
    }

    rltAndLtr() {
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
