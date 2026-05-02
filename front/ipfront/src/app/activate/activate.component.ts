import { Component } from '@angular/core';
import { LoginService } from '../services/login.service';
import { HttpResponse } from '@angular/common/http';
import { RegistrationService } from '../services/registration.service';

@Component({
  selector: 'app-activate',
  templateUrl: './activate.component.html',
  styleUrls: ['./activate.component.css']
})
export class ActivateComponent {

  username: string = '';
  password: string = '';
  
  constructor(private loginService: LoginService,
              private registrationService: RegistrationService
  ){

  }

  onSubmit(): void {
    const userAcc = {
      username: this.username,
      password: this.password,
      isActivate: 0
    }

    const user = {
      name: '',
      surname: '',
      city: '',
      mail: '',
      userAccount: userAcc
    }
    this.loginService.activate(userAcc).subscribe(
      (response: HttpResponse<any>) =>{
        this.registrationService.sendMail(user).subscribe((response: any) =>{
          console.log("Izvrseno je");
        })
    },
    (error: HttpResponse<any>) => {
      console.log('Neispravni podaci');
    }
  )
  }
}
