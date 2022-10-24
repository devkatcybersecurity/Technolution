import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from "../services/auth/auth.service";
import {User} from "../services/auth/user";
import {FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  user: any = {'username': '', password: ''};
  incorrectCredentials = false;

  loginForm = this.fb.group({
    username: '',
    password: ''
  })

  constructor(private authService: AuthService,
              private fb: FormBuilder,
              private router: Router) { }

  ngOnInit(): void {
  }


  login(data) {
    this.user.username = data.username;
    this.user.password = data.password;
    this.authService.login(this.user)
      .subscribe((response) => {
        console.log('response', response);
        this.onSignUpOrLogin.emit(response);
        this.router.navigate(['/history']).then(r => console.log(r));
      },
      error => {
        console.log('error', error);
        this.incorrectCredentials = true;
      });
  }

  @Output() onSignUpOrLogin = new EventEmitter<any>();

}
