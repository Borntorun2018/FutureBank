import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AppModule } from './app.module';
import { AuthGuard } from './shared';

const routes: Routes = [
    //Note LayoutModule contains:-    declarations: [LayoutComponent, SidebarComponent, HeaderComponent]   
    //==================================================================================================

    //guarded with urls "" to full page
    { path: '', loadChildren: './layout.module#LayoutModule', canActivate: [AuthGuard] },
      
    //Full page login display
    { path: 'login', loadChildren: './security/login/login.module#LoginModule' },
  
    //Full page signup display
    { path: 'signup', loadChildren: './security/signup/signup.module#SignupModule' },
      
    //Side, Header and inner home page display
    { path: 'home', loadChildren: './layout.module#LayoutModule'},
      
  //Side, Header and inner not found page display
    { path: '**', redirectTo: 'not-found' }
];


@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
