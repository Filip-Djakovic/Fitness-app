import { Component } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrls: ['./video-player.component.css']
})
export class VideoPlayerComponent {
  videoId: string = '_IZKnIsRxNc'; // Replace with your YouTube video ID
  sanitizedUrl: SafeResourceUrl;

  constructor(private sanitizer: DomSanitizer) {
    this.sanitizedUrl = this.getSafeUrl(this.videoId);
  }

  getSafeUrl(videoId: string): SafeResourceUrl {
    const url = `https://www.youtube.com/embed/${videoId}`;
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}
