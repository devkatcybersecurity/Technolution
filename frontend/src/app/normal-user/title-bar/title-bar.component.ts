import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-title-bar',
  templateUrl: './title-bar.component.html',
  styleUrls: ['./title-bar.component.css']
})
export class TitleBarComponent implements OnInit {


  showThisToolbarFeature: any = 'history';

  toggleToolbarBankingFeature($event: string) {
    this.showThisToolbarFeature = $event;
  }
  constructor() { }

  ngOnInit(): void {
  }


  newTransactionForm($event: MouseEvent) {
    console.log($event);
  }


}
