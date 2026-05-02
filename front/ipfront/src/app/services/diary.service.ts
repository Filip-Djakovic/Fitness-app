import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DiaryService {

  private url = 'http://localhost:8080/diarys'
  constructor(private http: HttpClient) { }

  create(diary: any){
    return this.http.post(`${this.url}`, diary);
  }

  
}
