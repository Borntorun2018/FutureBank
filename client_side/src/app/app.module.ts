import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpClient, HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';

import { ImageUploadModule } from 'angular2-image-upload';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe'; //importing the module
import { NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { NgxPermissionsModule} from 'ngx-permissions';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';


import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { AccessDeniedComponent } from "./components/access-denied/access-denied.component";


import { LayoutComponent } from './components/layout/layout.component';
import { UsersComponent } from "./components/admin/users.component";

import { ContactusComponent } from "./components/contactus/contactus.component";
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from "./components/login/login.component";
import { LogoutComponent } from "./components/logout/logout.component";
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ProfileComponent } from "./components/profile/profile.component";
import { ProductDetailComponent } from "./components/product/productDetail.component";
import { RegistrationComponent } from "./components/registration/registration.component";
import { TopNavBarComponent } from './components/topnavbar/topnavbar.component';
import { SideNavBarComponent } from './components/sidenavbar/sidenavbar.component';

import { appRoutes } from './routes';


import { TokenStorage } from './core/token.storage';
import { BrowserSideAuthGuard } from './services/security/browserside-auth-guard.service';
import { ServerSideAuthGuardService } from './services/security/serverside-authentication.service';
import { AuthenticationService } from './services/security/authentication.service';


import { ZoomableDirective }  from './components/product/zoomable.directive.js';

import { TokenInterceptor  } from './app.interceptor';


export function createTranslateLoader(http: HttpClient) {
    return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}




@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    AccessDeniedComponent,
    LayoutComponent,
    UsersComponent,
    ContactusComponent,
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    PageNotFoundComponent,
    ProfileComponent,
    ProductDetailComponent,
    RegistrationComponent,
    TopNavBarComponent,
    SideNavBarComponent,
    ZoomableDirective
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    Ng2SearchPipeModule, 
    Ng2OrderModule, 
    NgxPaginationModule,
    AngularFontAwesomeModule,
    ImageUploadModule.forRoot(),
    NgxPermissionsModule.forRoot(),
    NgbModule.forRoot(),
    TranslateModule.forRoot({
        loader: {
            provide: TranslateLoader,
            useFactory: createTranslateLoader,
            deps: [HttpClient]
        }
    }),
    RouterModule.forRoot(
    appRoutes 
    ),
    FormsModule
  ],
      
  providers: [
    AuthenticationService,
    TokenStorage,
    BrowserSideAuthGuard,
    ServerSideAuthGuardService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
     }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }