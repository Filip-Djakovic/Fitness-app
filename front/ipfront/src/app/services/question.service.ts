import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http: HttpClient) { }
  private url = 'http://localhost:8080/questions'

  getById(id: any){
    const newUrl = this.url+'/question/'+id;
    return this.http.get(`${newUrl}`);
  }

  updateQuestion(question: any){
    return this.http.put(`${this.url}`, question);
  }

  createQuestion(question: any){
    return this.http.post(`${this.url}`, question);
  }
}
