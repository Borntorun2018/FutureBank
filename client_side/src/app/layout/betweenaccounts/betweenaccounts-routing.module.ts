import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BetweenaccountsComponent } from './betweenaccounts.component';

const routes: Routes = [
    {
        path: '', component: BetweenaccountsComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class BetweenaccountsRoutingModule {
}
