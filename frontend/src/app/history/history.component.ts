import {Component, OnInit, ViewChild} from '@angular/core';
import {TransactionService} from "../services/transaction/transaction.service";
import {DataTableDirective, DataTablesModule} from "angular-datatables";
import {Subject} from "rxjs";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  data: any = [];
  cols: any = ['Reference', 'Number', 'Name',
  'Address', 'Phone', 'Amount', 'Currency', 'Beneficiary Bank',
    'Beneficiary Account', 'Card Type'];

  @ViewChild(DataTableDirective)
  dtElement: DataTableDirective | undefined;
  dtTrigger: any = new Subject();
  dtOptions: DataTables.Settings = {};

  constructor(private transactionService: TransactionService) { }



  ngOnInit(): void {
    this.transactionService.getTransactions().subscribe((response) => {
      console.log('Inside history : transactions: ', response[1]);
      this.data = response
      this.dtTrigger.next();
    });
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true
    };
  }

}
