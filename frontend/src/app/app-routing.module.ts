import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {HistoryComponent} from "./history/history.component";
import {NewTransactionComponent} from "./new-transaction/new-transaction.component";
import {UserProfileComponent} from "./user-profile/user-profile.component";

// This is where we will configure our routes
const routes: Routes = [
  { path: 'history', component: HistoryComponent },
  {
    path: 'login', component: LoginComponent,
  },
  {
    path:'signup',
    component: SignupComponent
  },
  {
    path: 'new-transaction', component: NewTransactionComponent
  },
  {
    path: 'profile', component: UserProfileComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
