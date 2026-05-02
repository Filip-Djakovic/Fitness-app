import { Component, OnInit } from '@angular/core';
import { RssFeedItem } from '../model/RssFeedItem';
import { RssFeedService } from '../services/rss-feed.service';

@Component({
  selector: 'app-rss-feed',
  templateUrl: './rss-feed.component.html',
  styleUrls: ['./rss-feed.component.css']
})
export class RssFeedComponent implements OnInit{
  items: RssFeedItem[] = [];

  constructor(private rssFeedService: RssFeedService) {}

  ngOnInit(): void {
    this.rssFeedService.getAllFeeds().subscribe((response) =>{
      this.items = response as RssFeedItem[]
    })
  }
  
}
