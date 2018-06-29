import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
import { AuthGuard } from './shared';
const routes: Routes = [
    {
        path: '', component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard' },
           
            { path: 'appointments', loadChildren: './layout/appointments/appointments.module#AppointmentsModule', canActivate: [AuthGuard] },
            { path: 'betweenaccounts', loadChildren: './layout/betweenaccounts/betweenaccounts.module#BetweenaccountsModule' , canActivate: [AuthGuard] },
            { path: 'blank-page', loadChildren: './layout/blank-page/blank-page.module#BlankPageModule'  },
            { path: 'deposit', loadChildren: './layout/deposit/deposit.module#DepositModule', canActivate: [AuthGuard]  },
            { path: 'persontoperson', loadChildren: './layout/persontoperson/persontoperson.module#PersontopersonModule', canActivate: [AuthGuard]  },
            { path: 'primary', loadChildren: './layout/primary/primary.module#PrimaryModule' , canActivate: [AuthGuard] },
            { path: 'profilesettings', loadChildren: './layout/profilesettings/profilesettings.module#ProfilesettingsModule', canActivate: [AuthGuard]  },
            { path: 'recipients', loadChildren: './layout/recipients/recipients.module#RecipientsModule', canActivate: [AuthGuard] },
            { path: 'registration', loadChildren: './layout/registration/registration.module#RegistrationModule', canActivate: [AuthGuard]  },
            { path: 'savings', loadChildren: './layout/savings/savings.module#SavingsModule', canActivate: [AuthGuard]  },
            { path: 'users', loadChildren: './admin/users/users.module#UsersModule' , canActivate: [AuthGuard] },
            { path: 'withdrawal', loadChildren: './layout/withdrawal/withdrawal.module#WithdrawalModule' , canActivate: [AuthGuard] },
                       
             { path: 'imagezoom', loadChildren: './layout/imagezoom/imagezoom.module#ImageZoomModule' , canActivate: [AuthGuard] },
             { path: 'fileupload', loadChildren: './layout/file-upload/file-upload.module#PageFileUploadModule' , canActivate: [AuthGuard] },
            
            
            
            
            { path: 'aboutus', loadChildren: './layout/about/about.module#AboutModule' },
            { path: 'contactus', loadChildren: './layout/contactus/contactus.module#ContactusModule' },
            
            
            { path: 'error', loadChildren: './general/server-error/server-error.module#ServerErrorModule' },
            { path: 'access-denied', loadChildren: './general/access-denied/access-denied.module#AccessDeniedModule' },
            { path: 'not-found', loadChildren: './general/not-found/not-found.module#NotFoundModule' }
            
             
        ],
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule {}





