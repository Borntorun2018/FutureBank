import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-savings',
    templateUrl: './savings.component.html',
    styleUrls: ['./savings.component.scss'],
    animations: [routerTransition()]
})
export class SavingsComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
