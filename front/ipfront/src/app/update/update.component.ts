import { Component } from '@angular/core';
import { LoginService } from '../services/login.service';
import { UserService } from '../services/user.service';
import { User } from '../model/User';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {


  user = {
    name: '',
    surname: '',
    city: '',
    mail: '',
    username: '',
    password: ''
  };
  userFromDB: User | undefined;
  constructor(private loginService: LoginService,
              private userService: UserService
  ){

  }
  onSubmit(): void{
    const userAcc = this.loginService.getLoggedInUser();
    console.log(userAcc.username);

    const acc = {
      username: this.user.username,
      password: this.user.password,
      isActivated: 1
    }

    const updateUser = {
      name: this.user.name,
      surname: this.user.surname,
      city: this.user.city,
      mail: this.user.mail,
      userAccount: acc
    }

    this.userService.updateUser(updateUser).subscribe((response) =>{
      console.log('Uspjesno ste azurirali podatke');
    })
  }
  ngOnInit(): void{
    const userAcc = this.loginService.getLoggedInUser();
    this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
      this.userFromDB = response as User;
      this.user.name = this.userFromDB.name;
      this.user.surname = this.userFromDB.surname;
      this.user.city = this.userFromDB.city;
      this.user.mail = this.userFromDB.mail;
      this.user.username = this.userFromDB.userAccount.username;
      this.user.password = this.userFromDB.userAccount.password;
    })
  }
}
