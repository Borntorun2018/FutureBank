import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfilesettingsRoutingModule } from './profilesettings-routing.module';
import { ProfilesettingsComponent } from './profilesettings.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, ProfilesettingsRoutingModule, PageHeaderModule],
    declarations: [ProfilesettingsComponent]
})
export class ProfilesettingsModule {}
