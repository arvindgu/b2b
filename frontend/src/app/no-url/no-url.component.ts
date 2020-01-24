import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-no-url',
  templateUrl: './no-url.component.html',
  styleUrls: ['./no-url.component.scss']
})
export class NoUrlComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public login() {
    this.router.navigate(['/login'])
  }

}
