import { Component, OnInit } from '@angular/core';
import { Programm } from '../model/Programm';
import { ProgrammService } from '../services/programm.service';
import { UserService } from '../services/user.service';
import { LoginService } from '../services/login.service';
import { User } from '../model/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-programms',
  templateUrl: './my-programms.component.html',
  styleUrls: ['./my-programms.component.css']
})
export class MyProgrammsComponent implements OnInit{
  ngOnInit(): void {
    const userAcc = this.loginService.getLoggedInUser();

    this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
      this.userFromDb = response as User;

      this.programmService.getProgrammsByUsers(this.userFromDb.id).subscribe((response) =>{
        this.items = response as Programm[];
      })
    })  
  }
  userFromDb: User | undefined;
  constructor(private programmService: ProgrammService,
              private userService: UserService,
              private loginService: LoginService,
              private router: Router
  ){}
  items: Programm[] = [];

  details(item: any){

  }
  createProgramm(){
    this.router.navigate(['/programmCreate'])
  }

  deleteItem(item: any, event: MouseEvent){
    event.stopPropagation();
    this.programmService.deleteProgram(item.id).subscribe((response) =>{
      console.log(response);
    })
   console.log(item);
  }

}
