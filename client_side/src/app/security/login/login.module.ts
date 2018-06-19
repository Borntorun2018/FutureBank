import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { LoginService } from './login.service';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { Observable } from 'rxjs/Observable';


@NgModule({
    imports: [CommonModule, LoginRoutingModule,FormsModule,HttpModule],
    declarations: [LoginComponent],
    providers: [LoginService]
})
export class LoginModule {}


