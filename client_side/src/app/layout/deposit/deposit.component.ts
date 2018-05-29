import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-deposit',
    templateUrl: './deposit.component.html',
    styleUrls: ['./deposit.component.scss'],
    animations: [routerTransition()]
})
export class DepositComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
