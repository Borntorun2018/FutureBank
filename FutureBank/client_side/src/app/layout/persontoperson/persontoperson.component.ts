import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-persontoperson',
    templateUrl: './persontoperson.component.html',
    styleUrls: ['./persontoperson.component.scss'],
    animations: [routerTransition()]
})
export class PersontopersonComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
