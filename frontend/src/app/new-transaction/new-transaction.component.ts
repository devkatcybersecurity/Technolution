import { Component, OnInit } from '@angular/core';
import {Transaction} from "../services/transaction/Transaction";
import {TransactionService} from "../services/transaction/transaction.service";
import {FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-transaction',
  templateUrl: './new-transaction.component.html',
  styleUrls: ['./new-transaction.component.css']
})
export class NewTransactionComponent implements OnInit {

  selectedValue: any;
  transactionDetail: Transaction = {
    'transactionType': '',
    'reference': '',
    'number': 0,
    'name': '',
    'address': '',
    'amount': 0,
    'currency': '',
    'beneficiary-bank': '',
    'beneficiary-account': 0,
    'card-number': 0,
    'card-expiry': '',
    'card-cvv': ''
  };

  transactionForm = this.fb.group({ ...this.transactionDetail});

  constructor(private transactionService: TransactionService,
              private fb: FormBuilder,
              private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(data) {
    // this.transactionService.newTransaction(data).subscribe((response) => {
    //     console.log('response', response);
    //     this.router.navigate(['/history']).then(r => console.log(r));
    //   });
  }
}
