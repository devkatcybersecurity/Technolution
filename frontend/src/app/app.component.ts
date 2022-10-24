import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedin = false;
  userDetails = {};
  showThisToolbarFeature: string = 'login';
  // use router to navigate on click

  constructor(private router: Router,
              ) {
  }


  onLogin($event) {
    console.log("inside on login");
    this.isLoggedin = true;
    this.userDetails = $event.value;
  }

  onLogout() {
    this.isLoggedin = false;
    this.userDetails = {};
    this.showThisToolbarFeature= 'login';
    this.router.navigate(['/login']).then(r => console.log( 'inside logout: ', this.isLoggedin));
  }

  toggleToolbarBankingFeature($event: string) {
    this.showThisToolbarFeature = $event;
    this.router.navigate(['/' + $event]).then(r => console.log(r));
  }
}
