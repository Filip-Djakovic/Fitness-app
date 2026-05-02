import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProgrammService {

  constructor(private http: HttpClient) { }
  private url = 'http://localhost:8080/programms'

  getProgramms(){
    return this.http.get(`${this.url}`);
  }
  getProgrammById(id: any){
    const newUrl = this.url+'/programm/'+id;
    return this.http.get(`${newUrl}`);
  }

  getProgrammsByUsers(id: any){
    const newUrl = this.url+'/programm_by_user/'+id;
    return this.http.get(`${newUrl}`);
  }
  createProgramm(programm: any){
    return this.http.post(`${this.url}`, programm);
  }
  deleteProgram(id: number){
    const newUrl = this.url+'/programm/'+id;
    return this.http.delete(`${newUrl}`)
  }
}
