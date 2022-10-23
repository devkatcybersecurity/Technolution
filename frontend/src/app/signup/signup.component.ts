import { Component, OnInit } from '@angular/core';
import {User} from "../services/auth/user";
import {AuthService} from "../services/auth/auth.service";
import {FormBuilder, FormGroup, ɵElement, ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User = {'username': '', password: '', email: '', firstName: '', lastName: '', role: 'user'};
  signupForm=  this.fb.group({
                                      firstName: '',
                                      lastName: '',
                                      username: '',
                                      email: '',
                                      password: '',
                                      confirmPassword: '',
                                      isAdmin: false
                                    })

  constructor(private authService: AuthService,
              private fb: FormBuilder) {}



  ngOnInit(): void {
  }

  onSubmit() {

  }

  signup(credentials: User) {
    this.authService.signup(credentials).subscribe((data) => {
      console.log('signup data: ' ,  data);

      // Redirect to user dashboard
    });
  }


  addNewUser(data) {
    console.log('inside add new user', data);
    this.user.username = data.username;
    this.user.password = data.password;
    this.user.email = data.email;
    this.user.firstName = data.firstName;
    this.user.lastName = data.lastName;
    if(data.isAdmin)
    {
      this.user.role = 'admin';
    }
    this.authService.signup(this.user).subscribe((data) => {
      console.log('addNewUser data: ' ,  data);
    });
  }


}
