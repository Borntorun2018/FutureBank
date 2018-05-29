import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersontopersonComponent } from './persontoperson.component';

const routes: Routes = [
    {
        path: '', component: PersontopersonComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PersontopersonRoutingModule {
}
