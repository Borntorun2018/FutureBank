import { Routes} from '@angular/router';
import { LoginComponent } from "./components/login/login.component";
import { LogoutComponent } from "./components/logout/logout.component";
import { HomeComponent } from "./components/home/home.component";
import { AboutComponent } from "./components/about/about.component";
import { AccessDeniedComponent } from "./components/access-denied/access-denied.component";
import { UsersComponent } from "./components/admin/users.component";
import { ContactusComponent } from "./components/contactus/contactus.component";
import { ProductDetailComponent } from "./components/product/productDetail.component";
import { ProfileComponent } from "./components/profile/profile.component";
import { RegistrationComponent } from "./components/registration/registration.component";


import { PageNotFoundComponent } from "./components/page-not-found/page-not-found.component";
import { BrowserSideAuthGuard } from "./services/security/browserside-auth-guard.service";

export const appRoutes: Routes = [
                                  { path: 'login',  component: LoginComponent },
                                  { path: 'logout', component: LogoutComponent, canActivate: [BrowserSideAuthGuard]},
                                  { path: 'home', component: HomeComponent },
                                  { path: 'aboutus', component: AboutComponent },
                                  { path: 'access-denied', component: AccessDeniedComponent },
                                  { path: 'users', component: UsersComponent , canActivate: [BrowserSideAuthGuard]},
                                  { path: 'contactus',component: ContactusComponent },
                                  { path: 'not-found', component: PageNotFoundComponent },
                                  { path: 'product', component: ProductDetailComponent, canActivate: [BrowserSideAuthGuard]},
                                  { path: 'profile', component: ProfileComponent, canActivate: [BrowserSideAuthGuard]},
                                  { path: 'registration', component: RegistrationComponent },
                                  { path: '',   redirectTo: '/home', pathMatch: 'full' },
                                  { path: '**', component: PageNotFoundComponent }
                              ];



    