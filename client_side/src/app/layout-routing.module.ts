import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';
const routes: Routes = [
    {
        path: '', component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard' },
           
            { path: 'appointments', loadChildren: './layout/appointments/appointments.module#AppointmentsModule' },
            { path: 'betweenaccounts', loadChildren: './layout/betweenaccounts/betweenaccounts.module#BetweenaccountsModule' },
            { path: 'blank-page', loadChildren: './layout/blank-page/blank-page.module#BlankPageModule' },
            { path: 'deposit', loadChildren: './layout/deposit/deposit.module#DepositModule' },
            { path: 'persontoperson', loadChildren: './layout/persontoperson/persontoperson.module#PersontopersonModule' },
            { path: 'primary', loadChildren: './layout/primary/primary.module#PrimaryModule' },
            { path: 'profilesettings', loadChildren: './layout/profilesettings/profilesettings.module#ProfilesettingsModule' },
            { path: 'recipients', loadChildren: './layout/recipients/recipients.module#RecipientsModule' },
            { path: 'registration', loadChildren: './layout/registration/registration.module#RegistrationModule' },
            { path: 'savings', loadChildren: './layout/savings/savings.module#SavingsModule' },
            { path: 'users', loadChildren: './admin/users/users.module#UsersModule' },
            { path: 'withdrawal', loadChildren: './layout/withdrawal/withdrawal.module#WithdrawalModule' },
                       

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





