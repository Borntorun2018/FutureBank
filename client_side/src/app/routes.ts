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
                                  
                                  
                                  
                                  {path: '', component: LayoutComponent,
                                      children: [
                                          { path: '', redirectTo: 'dashboard' },
                                         
                                          { path: 'appointments', loadChildren: './layout/appointments/appointments.module#AppointmentsModule', canActivate: [AuthGuard] },
                                          { path: 'betweenaccounts', loadChildren: './layout/betweenaccounts/betweenaccounts.module#BetweenaccountsModule' , canActivate: [AuthGuard] },
                                          { path: 'blank-page', loadChildren: './layout/blank-page/blank-page.module#BlankPageModule'  },
                                          { path: 'deposit', loadChildren: './layout/deposit/deposit.module#DepositModule', canActivate: [AuthGuard]  },
                                          { path: 'persontoperson', loadChildren: './layout/persontoperson/persontoperson.module#PersontopersonModule', canActivate: [AuthGuard]  },
                                          { path: 'primary', loadChildren: './layout/primary/primary.module#PrimaryModule' , canActivate: [AuthGuard] },
                                          { path: 'profilesettings', loadChildren: './layout/profilesettings/profilesettings.module#ProfilesettingsModule', canActivate: [AuthGuard]  },
                                          { path: 'recipients', loadChildren: './layout/recipients/recipients.module#RecipientsModule', canActivate: [AuthGuard] },
                                          { path: 'registration', loadChildren: './layout/registration/registration.module#RegistrationModule', canActivate: [AuthGuard]  },
                                          { path: 'savings', loadChildren: './layout/savings/savings.module#SavingsModule', canActivate: [AuthGuard]  },
                                          { path: 'users', loadChildren: './admin/users/users.module#UsersModule' , canActivate: [AuthGuard] },
                                          { path: 'withdrawal', loadChildren: './layout/withdrawal/withdrawal.module#WithdrawalModule' , canActivate: [AuthGuard] },
                                                     
                                           { path: 'imagezoom', loadChildren: './layout/imagezoom/imagezoom.module#ImageZoomModule' , canActivate: [AuthGuard] },
                                           { path: 'fileupload', loadChildren: './layout/file-upload/file-upload.module#PageFileUploadModule' , canActivate: [AuthGuard] },
                                          
                                          
                                          
                                          
                                          { path: 'aboutus', loadChildren: './layout/about/about.module#AboutModule' },
                                          { path: 'contactus', loadChildren: './layout/contactus/contactus.module#ContactusModule' },
                                          
                                          
                                          { path: 'error', loadChildren: './general/server-error/server-error.module#ServerErrorModule' },
                                          { path: 'access-denied', loadChildren: './general/access-denied/access-denied.module#AccessDeniedModule' },
                                          { path: 'not-found', loadChildren: './general/not-found/not-found.module#NotFoundModule' }
                                          
                                           
                                      ],
                                  },                              
                                 
                                  
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



    