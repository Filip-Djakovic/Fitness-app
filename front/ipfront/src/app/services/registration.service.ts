import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private urlRegistration = 'http://localhost:8080/users'

  constructor(private http: HttpClient) { }

  createUser(user: any){
    return this.http.post(`${this.urlRegistration}`, user);
  }

  sendMail(user: any){
    const newUrl = this.urlRegistration+'/activate'
    return this.http.post(`${newUrl}`, user);
  }
}
