import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrimaryRoutingModule } from './primary-routing.module';
import { PrimaryComponent } from './primary.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, PrimaryRoutingModule, PageHeaderModule],
    declarations: [PrimaryComponent]
})
export class PrimaryModule {}
