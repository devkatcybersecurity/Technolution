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
    'phone': 0,
    'amount': 0,
    'currency': '',
    'beneficiaryBank': '',
    'beneficiaryAccount': 0,
    'cardType': 'Debit',
    'cardNumber': 0,
    'cardExpiry': '',
    'cardCVV': ''
  };

  transactionForm = this.fb.group({ ...this.transactionDetail});

  constructor(private transactionService: TransactionService,
              private fb: FormBuilder,
              private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("data submitted in transaction is : ", this.transactionDetail);
    this.transactionService.addTransaction(this.transactionDetail).subscribe((response) => {
      console.log("response in transaction is : ", response);
    });
  }
    // this.transactionService.newTransaction(data).subscribe((response) => {
    //     console.log('response', response);
    //     this.router.navigate(['/history']).then(r => console.log(r));
    //   });

}
