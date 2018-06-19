import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PersontopersonRoutingModule } from './persontoperson-routing.module';
import { PersontopersonComponent } from './persontoperson.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, PersontopersonRoutingModule, PageHeaderModule],
    declarations: [PersontopersonComponent]
})
export class PersontopersonModule {}
