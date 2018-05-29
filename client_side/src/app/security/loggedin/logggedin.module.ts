import { NgModule } from '@angular/core';
import { LoggedinServiceTs } from './loggedin.service';
import { HttpClientModule, HttpClientJsonpModule  } from '@angular/common/http';
import { HttpModule } from '@angular/http';

@NgModule({
    imports: [HttpClientModule,
              HttpClientJsonpModule,
               HttpModule],
    declarations: [],
    providers: [LoggedinServiceTs]
})
export class LogggedinModule {}
