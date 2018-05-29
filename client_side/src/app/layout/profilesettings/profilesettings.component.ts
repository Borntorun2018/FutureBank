import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-primary',
    templateUrl: './profilesettings.component.html',
    styleUrls: ['./profilesettings.component.scss'],
    animations: [routerTransition()]
})
export class ProfilesettingsComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
