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

  ngOnInit(): void {
    this.isLoggedin = localStorage.getItem('Authorization') ? true : false;
    if(this.isLoggedin) {
      this.showThisToolbarFeature = 'history';
      this.router.navigate(['/history']).then(r => console.log(r));
    }
  }

  onLogin($event) {
    console.log("inside on login");
    this.isLoggedin = localStorage.getItem('Authorization') ? true : false;
    this.router.navigate(['/history']).then(r => console.log(r));
    this.userDetails = $event.value;
  }

  onLogout() {
    this.isLoggedin = false;
    this.userDetails = {};
    this.showThisToolbarFeature= 'login';
    if(localStorage.getItem('Authorization')) {
      localStorage.removeItem('Authorization');
    }
    this.router.navigate(['/login']).then(r => console.log( 'inside logout: ', this.isLoggedin));

  }

  toggleToolbarBankingFeature($event: string) {
    this.showThisToolbarFeature = $event;
    this.router.navigate(['/' + $event]).then(r => console.log(r));
  }
}
