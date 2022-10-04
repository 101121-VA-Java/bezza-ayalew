import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormioModule, FormioAppConfig } from '@formio/angular';
import { FormioResources } from '@formio/angular/resource';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppConfig } from 'src/config';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { FormioAuthConfig, FormioAuthService } from '@formio/angular/auth';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    CommonModule,
    FormioModule,
    RouterModule
  ],
  providers: [{provide: FormioAppConfig, useValue: AppConfig},
    FormioResources,
    FormioAuthService,
    {provide: FormioAuthConfig, useValue: {
      login: {
        form: 'user/login'
      },
      register: {
        form: 'user/register'
      }
    }}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
