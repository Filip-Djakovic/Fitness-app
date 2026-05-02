import { Component } from '@angular/core';
import { RegistrationService } from '../services/registration.service';
import { User } from '../model/User';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  constructor(private registrationService: RegistrationService){}

  user = {
    name: '',
    surname: '',
    city: '',
    mail: '',
    username: '',
    password: ''
  };

  userForRegistration: User | undefined

  onSubmit(): void{

    const userAcc = {
      username: this.user.username,
      password: this.user.password,
      isActivated: 0
    };

    const createdUser = {
      name: this.user.name,
      surname: this.user.surname,
      city: this.user.city,
      mail: this.user.mail,
      userAccount: userAcc
    };

    this.registrationService.createUser(createdUser).subscribe((response: any) =>{
      this.registrationService.sendMail(createdUser).subscribe((response: any) =>{
        console.log("Izvrseno je");
      })
    })

    

  }
}
