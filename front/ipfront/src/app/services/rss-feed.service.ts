import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RssFeedService {

  private url = 'http://localhost:8080/rss_feeds'

  constructor(private http: HttpClient) { }

  getAllFeeds(){
    return this.http.get(`${this.url}`);
  }
}
