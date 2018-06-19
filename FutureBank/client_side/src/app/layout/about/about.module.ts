import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgxPermissionsModule} from 'ngx-permissions';
import { AboutRoutingModule } from './about-routing.module';
import { AboutComponent } from './about.component';
import { PageHeaderModule } from './../../shared';

//import { NgxPermissionsModule } from 'ngx-permissions';

@NgModule({
    imports: [CommonModule, 
              AboutRoutingModule, 
              // Specify your library as an import
              NgxPermissionsModule.forRoot(),
              PageHeaderModule],
    declarations: [AboutComponent]
})
export class AboutModule {}
