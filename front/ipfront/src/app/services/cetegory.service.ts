import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CetegoryService {

  private url = 'http://localhost:8080/categorys'
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${this.url}`);
  }
}
