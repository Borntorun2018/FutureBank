import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';

import { LayoutRoutingModule } from './layout-routing.module';
import { LayoutComponent } from './layout.component';

import { SidebarComponent } from './layout/components/sidebar/sidebar.component';
import { HeaderComponent } from './layout/components/header/header.component';
import { NgxPermissionsModule } from 'ngx-permissions';


@NgModule({
    imports: [
        CommonModule,
        LayoutRoutingModule,
        TranslateModule,
       // NgxPermissionsModule.forChild(),
        
        NgxPermissionsModule.forChild({permissionsIsolate: true, rolesIsolate: true}),
        NgbDropdownModule.forRoot()
    ],
    declarations: [LayoutComponent, SidebarComponent, HeaderComponent]

})


export class LayoutModule {}
