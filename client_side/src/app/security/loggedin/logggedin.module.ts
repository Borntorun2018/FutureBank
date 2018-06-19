import { NgModule } from '@angular/core';
import { LoggedinService } from './loggedin.service';
import { HttpClientModule, HttpClientJsonpModule  } from '@angular/common/http';
import { HttpModule } from '@angular/http';

@NgModule({
    imports: [HttpClientModule,
              HttpClientJsonpModule,
               HttpModule],
    declarations: [],
    providers: [LoggedinService]
})
export class LogggedinModule {}
