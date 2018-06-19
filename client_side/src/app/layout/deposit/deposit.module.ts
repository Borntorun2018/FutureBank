import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DepositRoutingModule } from './deposit-routing.module';
import { DepositComponent } from './deposit.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, DepositRoutingModule, PageHeaderModule],
    declarations: [DepositComponent]
})
export class DepositModule {}
