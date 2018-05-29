import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-primary',
    templateUrl: './primary.component.html',
    styleUrls: ['./primary.component.scss'],
    animations: [routerTransition()]
})
export class PrimaryComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
