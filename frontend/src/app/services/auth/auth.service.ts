import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "./user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  signup(credentials: User): Observable<Object> {
    console.log('inside signup');
    return this.http.post('http://localhost:3000/signup', credentials);
  }


}
