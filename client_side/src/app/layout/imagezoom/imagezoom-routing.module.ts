import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ImageZoomComponent } from './imagezoom.component';

const routes: Routes = [
    {
        path: '', component: ImageZoomComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ImageZoomRoutingModule {
}

