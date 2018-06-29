import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PageFileUploadComponent } from './page-file-upload.component';


const routes: Routes = [
    {
        path: '', component: PageFileUploadComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PageFileUploadRoutingModule {
   
}
