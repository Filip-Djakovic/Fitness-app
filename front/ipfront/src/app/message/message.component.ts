import { Component } from '@angular/core';
import { MessageService } from '../services/message.service';
import { LoginService } from '../services/login.service';
import { UserService } from '../services/user.service';
import { User } from '../model/User';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent {
  message: string = '';
  userFromDB: User | undefined;
  constructor(private messageSerice: MessageService,
             private loginService: LoginService,
             private userService: UserService) {}

  onSendMessage() {
    if (this.message.trim()) {
      const userAcc = this.loginService.getLoggedInUser();

      this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
        this.userFromDB = response as User;
        const mess = {
          text: this.message,
          isRead: 0,
          user: this.userFromDB
        }
        this.messageSerice.sendMessage(mess).subscribe((response) =>{
          console.log('Poruka je poslata savjetniku');
        })
      })
    }
  }
}
