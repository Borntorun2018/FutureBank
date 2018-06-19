import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
import { UsersService } from './users.service';

import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe'; //importing the module
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
import { FormsModule }    from '@angular/forms';

@NgModule({
    imports: [CommonModule,
              UsersRoutingModule,
              FormsModule,
              Ng2SearchPipeModule, 
              Ng2OrderModule, 
              NgxPaginationModule
              ],
    declarations: [UsersComponent],
    providers: [UsersService]
})
export class UsersModule {}
