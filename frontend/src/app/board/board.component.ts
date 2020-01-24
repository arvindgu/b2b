import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnInit {
  public count: string = '3';
  public goods:any = [
    {name: "Bag Aspect 1", src: "../../assets/1.jpeg"},
    {name: "Bag Aspect 2", src: "../../assets/2.jpeg"},
    {name: "Bag Aspect 3", src: "../../assets/3.jpeg"}
  ];
  public goodsSelected:any = [
    {name: "Bag Aspect 1", src: "../../assets/1.jpeg"},
    {name: "Bag Aspect 2", src: "../../assets/2.jpeg"},
    {name: "Bag Aspect 3", src: "../../assets/3.jpeg"}
  ];
  constructor() { }

  ngOnInit() {
  }

  public drop($event) {
    console.log($event.data);
    this.goodsSelected.push([$event.data]);
  }

}
