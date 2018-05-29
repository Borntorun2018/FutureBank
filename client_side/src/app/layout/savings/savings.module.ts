import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SavingsRoutingModule } from './savings-routing.module';
import { SavingsComponent } from './savings.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, SavingsRoutingModule, PageHeaderModule],
    declarations: [SavingsComponent]
})
export class SavingsModule {}
