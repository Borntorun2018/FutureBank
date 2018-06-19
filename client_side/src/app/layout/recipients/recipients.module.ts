import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RecipientsRoutingModule } from './recipients-routing.module';
import { RecipientsComponent } from './recipients.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, RecipientsRoutingModule, PageHeaderModule],
    declarations: [RecipientsComponent]
})
export class RecipientsModule {}
