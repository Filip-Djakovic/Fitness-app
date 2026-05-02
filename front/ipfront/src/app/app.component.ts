import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ipfront';

  username: string = '';
  password: string = '';

  onSubmit(): void {
    if (this.username && this.password) {
      console.log('Username:', this.username);
      console.log('Password:', this.password);
      // Implement login logic here, such as calling an authentication service
    }
  }
}
