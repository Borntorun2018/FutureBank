import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppointmentsRoutingModule } from './appointments-routing.module';
import { AppointmentsComponent } from './appointments.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, AppointmentsRoutingModule, PageHeaderModule],
    declarations: [AppointmentsComponent]
})
export class AppointmentsModule {}
