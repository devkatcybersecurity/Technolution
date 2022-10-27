import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user = { username: "", email: "", firstName: "", lastName: "", role: "" }

  constructor() { }
  ngOnInit(): void {
    // @ts-ignore
    this.user = JSON.parse(localStorage.getItem('Authorization'));


  }



}
