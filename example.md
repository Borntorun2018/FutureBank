
import { Injectable } from '@angular/core';
import {Router, Resolve,ActivatedRouteSnapshot} from '@angular/router';
import { Hero } from './hero';
import { HeroService } from './hero.service';

@Injectable()
export class HeroDetailResolve implements Resolve {

    constructor(private heroService: HeroService, private router: Router) { }
    
    resolve(route: ActivatedRouteSnapshot): Promise | boolean {
    
        let id = +route.params['id'];
        
        return this.heroService.getHero(id).then(hero => {
            if (hero) {
                return hero;
            } else { // id not found
                this.router.navigate(['/dashboard']);
                return false;
            }
        });
    }
}
====================================
/ app-routing.module.ts

import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent }   from './dashboard.component';
import { HeroesComponent }      from './heroes.component';
import { HeroDetailComponent }  from './hero-detail.component';
import { HeroDetailResolve } from './hero-detail-resolve.service';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { 
    path: 'dashboard',  
    component: DashboardComponent,
  },
  { 
    path: 'detail/:id', 
    component: HeroDetailComponent,
    resolve: {
      hero: HeroDetailResolve
    },
  },
  { path: 'heroes',     component: HeroesComponent }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  providers: [
    HeroDetailResolve
  ]
})
export class AppRoutingModule {}
=========================================
// hero-detail.component.ts

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
import { Hero } from './hero';
import { HeroService } from './hero.service';

@Component({
  moduleId: module.id,
  selector: 'my-hero-detail',
  templateUrl: 'hero-detail.component.html',
  styleUrls: ['hero-detail.component.css']
})

export class HeroDetailComponent implements OnInit {
  hero: Hero;
  constructor(
    private heroService: HeroService,
    private route: ActivatedRoute,
    private location: Location
  ) { }

  ngOnInit(): void {
    this.route.data
      .subscribe((data: { hero: Hero }) => {
        this.hero = data.hero;
      });
  }

  save(): void {
    this.heroService.update(this.hero)
      .then(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }
}