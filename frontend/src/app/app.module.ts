import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationBarComponent } from './normal-user/navigation-bar/navigation-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './admin/admin.component';
import { NormalUserComponent } from './normal-user/normal-user.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import { TitleBarComponent } from './normal-user/title-bar/title-bar.component';
import {MatButtonModule} from "@angular/material/button";
import {MatMenuModule} from "@angular/material/menu";
import { NewTransactionComponent } from './normal-user/new-transaction/new-transaction.component';
import { HistoryComponent } from './normal-user/history/history.component';
import { UserProfileComponent } from './normal-user/user-profile/user-profile.component';

@NgModule({
  declarations: [
    // contains components, directives, and pipes that are part of this module
    AppComponent,
    NavigationBarComponent,
    AdminComponent,
    NormalUserComponent,
    TitleBarComponent,
    NewTransactionComponent,
    HistoryComponent,
    UserProfileComponent
  ],
  imports: [
    // contains other modules, whose classes are needed by components of the module they are being imported into
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule
  ],
  // providers - contains any services that are required by components. If a service is added to the module level, it is ava
  providers: [],
  // bootstrap - contains  the main component or the root component of the application
  bootstrap: [AppComponent]
})
export class AppModule { }
