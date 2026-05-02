import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { HttpResponse } from '@angular/common/http';
import { MailService } from '../services/mail.service';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent {
  title = 'ipfront';

  username: string = '';
  password: string = '';

  constructor(private router: Router, 
              private loginService: LoginService,
              private mailService: MailService  
            ){
    
  }

  onSubmit(): void {
    if (this.username && this.password) {
      console.log('Username:', this.username);
      console.log('Password:', this.password);
      //this.router.navigate(['side-nav-bar']);

      const user = {
        username: this.username,
        password: this.password,
        isActivated: 1
      }

      this.loginService.login(user).subscribe(
        (response: HttpResponse<any>) => {
          this.loginService.loginUser(user);
          this.router.navigate(['/side-nav-bar']) 
        },
        (error: HttpResponse<any>) => {
          if(error.status == 401)
            this.router.navigate(['/activate']);
          else if(error.status == 451)
            console.log('Imate pravo pristupa samo jsp aplikacijama');
          else
            console.log('Nepostojeci nalog');
        }
      );
      this.sendLoginEmail("Novokreirani programi");
    }
  }

  navigateToRegistration() {
    // Navigate to the registration page
    this.router.navigate(['/registration']);
  }

  onLabelPage(){
    this.router.navigate(['/rssFeed']);
  }
  onLabelProgramms(){
    this.router.navigate(['/programm']);
  }
  onLabelExcersise(){
    this.router.navigate(['/exersise']);
  }

  sendLoginEmail(message: any): void {
    this.mailService.sendMail(message).subscribe({
      next: (response) => {
        console.log('Email sent successfully:', response);
      },
      error: (error) => {
        console.error('Error sending email:', error);
      }
    });
  }

}
