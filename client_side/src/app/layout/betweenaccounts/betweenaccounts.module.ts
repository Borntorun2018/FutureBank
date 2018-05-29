import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BetweenaccountsRoutingModule } from './betweenaccounts-routing.module';
import { BetweenaccountsComponent } from './betweenaccounts.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, BetweenaccountsRoutingModule, PageHeaderModule],
    declarations: [BetweenaccountsComponent]
})
export class BetweenaccountsModule {}
