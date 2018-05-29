import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-withdrawal',
    templateUrl: './withdrawal.component.html',
    styleUrls: ['./withdrawal.component.scss'],
    animations: [routerTransition()]
})
export class WithdrawalComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
