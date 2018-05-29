import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-contacts',
    templateUrl: './contactus.component.html',
    styleUrls: ['./contactus.component.scss'],
    animations: [routerTransition()]
})
export class ContactusComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
