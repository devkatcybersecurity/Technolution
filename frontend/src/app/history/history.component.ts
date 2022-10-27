import { Component, OnInit } from '@angular/core';
import {TransactionService} from "../services/transaction/transaction.service";
import {DataTablesModule} from "angular-datatables";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  data: any = [];
  cols: any = ['Reference', 'Number', 'Name',
  'Address', 'Phone', 'Amount', 'Currency', 'Beneficiary Bank',
    'Beneficiary Account', 'Card Type', 'Card Number', 'Card Expiry', 'Card CVV'];


  constructor(private transactionService: TransactionService) { }



  ngOnInit(): void {
    this.transactionService.getTransactions().subscribe((response) => {
      console.log('Inside history : transactions: ', response[1]);
      this.data = response
    });
  }

}
