import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-normal-user',
  templateUrl: './normal-user.component.html',
  styleUrls: ['./normal-user.component.css']
})
export class NormalUserComponent implements OnInit {
  showNewTransaction: any;

  // method to show new transaction form if clicked on new transaction button
  showNewTransactionForm() {
    this.showNewTransaction = true;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
