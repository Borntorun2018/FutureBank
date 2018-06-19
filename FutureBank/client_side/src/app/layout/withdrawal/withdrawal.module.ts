import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WithdrawalRoutingModule } from './withdrawal-routing.module';
import { WithdrawalComponent } from './withdrawal.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, WithdrawalRoutingModule, PageHeaderModule],
    declarations: [WithdrawalComponent]
})
export class WithdrawalModule {}
