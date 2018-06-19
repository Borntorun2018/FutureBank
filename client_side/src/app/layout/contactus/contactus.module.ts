import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContactusRoutingModule } from './contactus-routing.module';
import { ContactusComponent } from './contactus.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, ContactusRoutingModule, PageHeaderModule],
    declarations: [ContactusComponent]
})
export class ContactusModule {}
