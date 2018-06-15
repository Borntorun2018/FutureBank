import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule, HTTP_INTERCEPTORS, HttpClient, HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { HttpModule } from '@angular/http';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthGuard } from './shared';

//import { LogggedinModule } from './loggedin/logggedin.module';  //Monday removed
import { LoggedinService } from './security/loggedin/loggedin.service';  
import { LoginService } from './security/login/login.service';  

import { UsersModule } from './admin/users/users.module';

//import { UsersComponent } from './admin/users/users.component';
import { UsersService } from './admin/users/users.service';
import { User } from './admin/user/user';

import { Interceptor } from './app.interceptor';

import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe'; //importing the module
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import {NgxPermissionsModule} from 'ngx-permissions';
import {TokenStorage} from './shared/token.storage';

// AoT requires an exported function for factories
export function createTranslateLoader(http: HttpClient) {
    return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}


@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        FormsModule,
        
        HttpClientModule,
        HttpModule,
     // Specify your library as an import
        NgxPermissionsModule.forRoot(),
        NgbModule.forRoot(),
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: createTranslateLoader,
                deps: [HttpClient]
            }
        }),
        
        Ng2SearchPipeModule, //including into imports
        Ng2OrderModule, //add here
        NgxPaginationModule,
       
        AppRoutingModule
//        exports: [
//                  SharedComponent
//              ]
    ],
    //declarations: [AppComponent,UsersComponent],
    declarations: [AppComponent],
    providers: [AuthGuard,LoginService,LoggedinService,UsersService,User,TokenStorage,
      {provide: HTTP_INTERCEPTORS,
        useClass: Interceptor,
        multi : true}       
                 ],
    //providers: [AuthGuard,LogggedinModule,UsersService,User],    //monday removed
    
    
    //declarations: [AppComponent],
    //providers: [AuthGuard,LogggedinModule],
    bootstrap: [AppComponent]
})
export class AppModule {}
