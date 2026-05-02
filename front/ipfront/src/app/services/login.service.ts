import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  private urlLogin = 'http://localhost:8080/users_account'

  login(user: any): Observable<HttpResponse<any>>{
    return this.http.post<any>(`${this.urlLogin}` ,user, { observe: 'response' });
  }

  activate(user: any): Observable<HttpResponse<any>>{
    const newUrl = this.urlLogin+'/activate'
    return this.http.post<any>(`${newUrl}` ,user, { observe: 'response' });
  }

  loginUser(userData: any) {
    // Assuming userData is an object with user details
    localStorage.setItem('loggedInUser', JSON.stringify(userData));
  }

  getLoggedInUser() {
    const user = localStorage.getItem('loggedInUser');
    return user ? JSON.parse(user) : null;
  }

  logoutUser() {
    localStorage.removeItem('loggedInUser');
  }
  
}
