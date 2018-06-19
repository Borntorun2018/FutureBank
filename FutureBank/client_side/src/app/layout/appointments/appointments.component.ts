import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-appointments',
    templateUrl: './appointments.component.html',
    styleUrls: ['./appointments.component.scss'],
    animations: [routerTransition()]
})
export class AppointmentsComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
