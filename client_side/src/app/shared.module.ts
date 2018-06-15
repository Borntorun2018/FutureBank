import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxPermissionsModule } from 'ngx-permissions';

@NgModule({
    exports: [
        CommonModule,
        NgxPermissionsModule
    ]
})
export class SharedModule { }