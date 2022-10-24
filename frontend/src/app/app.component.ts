import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedin = false;
  userDetails = {};
  showThisToolbarFeature: string = 'login';

  onLogin($event) {
    console.log("inside on login");
    this.isLoggedin = true;
    this.userDetails = $event.value;
  }

  onLogout() {
    this.isLoggedin = false;
    this.userDetails = {};
  }

  toggleToolbarBankingFeature($event: string) {
    this.showThisToolbarFeature = $event;
  }
}
