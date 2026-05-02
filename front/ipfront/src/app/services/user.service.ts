import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  private url = 'http://localhost:8080/users'

  getUserByUserName(username: string) {
    const newUrl = this.url+'/user_n/'+username;
    return this.http.get(`${newUrl}`)
  }

  updateUser(user: any){
    return this.http.put(`${this.url}`, user);
  }
}
