import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegistrationRoutingModule } from './registration-routing.module';
import { RegistrationComponent } from './registration.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, RegistrationRoutingModule, PageHeaderModule],
    declarations: [RegistrationComponent]
})
export class RegistrationModule {}
