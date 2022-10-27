import { Injectable } from '@angular/core';
import {Transaction} from "./Transaction";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  addTransaction(data: Transaction) : Observable<Object> {

      // @ts-ignore
      let res = this.http.post('http://localhost:3000/add-transaction', data, {headers: {authorization: JSON.parse(localStorage.getItem('Authorization'))!.username}});
      return res;
    }

    getTransactions() : Observable<Object> {
      // add authorization header in req object and call the http get api
      // @ts-ignore
      let res = this.http.get('http://localhost:3000/transactions', {headers: {authorization: JSON.parse(localStorage.getItem('Authorization'))!.username}});
      return res.pipe();
    }
}
