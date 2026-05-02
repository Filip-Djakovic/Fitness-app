import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MailService {

  constructor(private http : HttpClient) { }

  private url = 'http://localhost:8080/email'


  sendMail(message: any){
    return this.http.post(`${this.url}`, message);
  }
}
