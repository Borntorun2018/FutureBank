import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AboutRoutingModule } from './about-routing.module';
import { AboutComponent } from './about.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, AboutRoutingModule, PageHeaderModule],
    declarations: [AboutComponent]
})
export class AboutModule {}
