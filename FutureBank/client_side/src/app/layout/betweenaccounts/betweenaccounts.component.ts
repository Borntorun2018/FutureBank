import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-betweenaccounts',
    templateUrl: './betweenaccounts.component.html',
    styleUrls: ['./betweenaccounts.component.scss'],
    animations: [routerTransition()]
})
export class BetweenaccountsComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
