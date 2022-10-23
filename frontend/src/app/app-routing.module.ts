import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {NormalUserComponent} from "./normal-user/normal-user.component";
import {NewTransactionComponent} from "./normal-user/new-transaction/new-transaction.component";

// This is where we will configure our routes
const routes: Routes = [
  {path: '', component: NormalUserComponent},
  {path: 'new-transaction', component: NewTransactionComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
