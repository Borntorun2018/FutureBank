import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxPermissionsService } from 'ngx-permissions';
import {TokenStorage} from './../../core/token.storage';

@Component({
    selector: 'app-navbar',
    templateUrl: './topnavbar.component.html',
    styleUrls: ['./topnavbar.component.scss']
})
export class TopNavBarComponent implements OnInit {
    
    pushRightClass: string = 'push-right';
    username: string ='anonymous';
    loading = true;
    constructor(private permissionsService : NgxPermissionsService,
                private translate: TranslateService, 
                private tokenStorage: TokenStorage,
                public router: Router) {
        debugger;
        let perms: [any]=[this.tokenStorage.getUsernameAuthority()];
        this.permissionsService.loadPermissions(perms);
        debugger;
        
        let currentuser = JSON.parse(sessionStorage.getItem('isLoggedin')); 
        
        if (currentuser !== null) {
            this.username = currentuser.username;
         }else{
            this.username = "anonymous";
         }
         debugger;
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

    ngOnInit() {}
        
    ngAfterViewInit() {
        debugger;
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
