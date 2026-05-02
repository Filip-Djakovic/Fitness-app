import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PdfService {

  private url = 'http://localhost:8080/pdf_downloader'
  constructor(private http: HttpClient) { }

  getById(id: number){
    const newURL = this.url+'/download/'+id 

    console.log(newURL);
    return this.http.get(`${newURL}`, { responseType: 'blob' });
  }
}
