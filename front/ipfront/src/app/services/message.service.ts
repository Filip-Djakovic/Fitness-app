import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private url = 'http://localhost:8080/messages'
  constructor(private http: HttpClient) { }

  sendMessage(message: any){
    return this.http.post(`${this.url}`, message);
  }
}
