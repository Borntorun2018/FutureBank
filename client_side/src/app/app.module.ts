import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { AccessDeniedComponent } from "./components/access-denied/access-denied.component";


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

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    AccessDeniedComponent,
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
    SideNavBarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
    appRoutes 
    ),
    FormsModule
  ],
  providers: [
    AuthenticationService,
    TokenStorage,
    BrowserSideAuthGuard,
    ServerSideAuthGuardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }