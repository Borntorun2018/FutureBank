import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
    
    pushRightClass: string = 'push-right';
    username: string ='anonymous';
    loading = true;
    constructor(private translate: TranslateService, public router: Router) {
         
        let currentuser = JSON.parse(sessionStorage.getItem('isLoggedin')); 
        
        if (currentuser !== null) {
            this.username = currentuser.username;
         }else{
            this.username = "anonymous";
         }
         
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
