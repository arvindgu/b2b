import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }
  public getDetails(){
    return this.httpClient.get('https://reqres.in/api/unknown');
  }
}
