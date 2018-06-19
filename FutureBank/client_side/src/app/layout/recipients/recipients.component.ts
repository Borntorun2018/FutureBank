import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-primary',
    templateUrl: './recipients.component.html',
    styleUrls: ['./recipients.component.scss'],
    animations: [routerTransition()]
})
export class RecipientsComponent implements OnInit {
    constructor() {}

    ngOnInit() {}
}
