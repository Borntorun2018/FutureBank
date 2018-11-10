import { Routes} from '@angular/router';
import { LoginComponent } from "./components/login/login.component";
import { LogoutComponent } from "./components/logout/logout.component";
import { HomeComponent } from "./components/home/home.component";
import { AboutComponent } from "./components/about/about.component";
import { AccessDeniedComponent } from "./components/access-denied/access-denied.component";
import { UsersComponent } from "./components/admin/users.component";
import { UserComponent } from "./components/admin/user.component";

import { AppComponent } from "./app.component";

import { ContactusComponent } from "./components/contactus/contactus.component";
import { ProductDetailComponent } from "./components/product/productDetail.component";
import { ProfileComponent } from "./components/profile/profile.component";
import { RegistrationComponent } from "./components/registration/registration.component";
import { LayoutComponent } from './components/layout/layout.component';


import { DemoComponent } from "./components/demo/demo.component";
import { DemoComponent2 } from "./components/demo2/demo2.component";
import { DemoComponent3 } from "./components/demo3/demo3.component";

import { PageNotFoundComponent } from "./components/page-not-found/page-not-found.component";
import { BrowserSideAuthGuard } from "./services/security/browserside-auth-guard.service";

export const appRoutes: Routes = [
                                   {path: '', component: LayoutComponent,
                                      children: [
                                            { path: 'root', component: AppComponent },
                                            { path: 'home', component: HomeComponent },
                                            { path: 'login',  component: LoginComponent },   
                                            { path: 'aboutus', component: AboutComponent },
                                            { path: 'contactus',component: ContactusComponent },
                                            { path: 'registration', component: RegistrationComponent },
                                            { path: 'users', component: UsersComponent },
                                           
                                             { path: 'demo',component: DemoComponent },
                                             { path: 'demo2',component: DemoComponent2 },
                                             { path: 'demo3',component: DemoComponent3 },
 
                                          
                                            { path: 'user/:id/:status', component: UserComponent },
                                           
                                           
                                            { path: 'logout', component: LogoutComponent},
                                            { path: 'not-found', component: PageNotFoundComponent },
                                            { path: 'product', component: ProductDetailComponent},
                                            { path: 'profile', component: ProfileComponent, canActivate: [BrowserSideAuthGuard]},
                                            { path: 'access-denied', component: AccessDeniedComponent },
                                            { path: '',   redirectTo: '/home', pathMatch: 'full' },   
                                            { path: '**', component: PageNotFoundComponent }
                                      ],
                                  },                              
                                 // { path: '',   redirectTo: '/home', pathMatch: 'full' }
                              ];
    