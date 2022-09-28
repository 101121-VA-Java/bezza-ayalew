import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormioModule, FormioAppConfig } from 'angular-formio';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppConfig } from 'src/config';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormioModule,
    RouterModule
  ],
  providers: [{provide: FormioAppConfig, useValue: AppConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
