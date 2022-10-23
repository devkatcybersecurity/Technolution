import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedin = false;
  userDetails = {};

  onLogin($event) {
    console.log("inside on login");
    this.isLoggedin = true;
    this.userDetails = $event.value;
  }

  onLogout() {
    this.isLoggedin = false;
    this.userDetails = {};
  }
}
