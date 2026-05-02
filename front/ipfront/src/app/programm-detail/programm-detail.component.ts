import { Component, OnInit } from '@angular/core';
import { Programm } from '../model/Programm';
import { ActivatedRoute, Router } from '@angular/router';
import { ProgrammService } from '../services/programm.service';
import { Location } from '@angular/common';
import { Question } from '../model/Question';
import { QuestionService } from '../services/question.service';
import { LoginService } from '../services/login.service';
import { User } from '../model/User';
import { UserService } from '../services/user.service';
@Component({
  selector: 'app-programm-detail',
  templateUrl: './programm-detail.component.html',
  styleUrls: ['./programm-detail.component.css']
})
export class ProgrammDetailComponent implements OnInit{
  item: Programm | undefined
  questions: Question[] = [];
  newQuestionText: string = '';
  participateText: string = '';
  userFromDb: User | undefined;
  constructor(private route: ActivatedRoute,
              private programmService: ProgrammService,
              private questionService: QuestionService,
              private router: Router,
              private loginService: LoginService,
              private userService: UserService
  ) {}
  ngOnInit(): void {
    const itemId = this.route.snapshot.paramMap.get('id');

    this.programmService.getProgrammById(itemId).subscribe((response) =>{
      this.item = response as Programm;
    })

    this.questionService.getById(itemId).subscribe((response) =>{
      this.questions = response as Question[];
    })
  }

  details(item: any){

  }
  updateResponse(question: any){
    const user = this.loginService.getLoggedInUser();
    if(user != null) {
      this.questionService.updateQuestion(question).subscribe((response) =>{
        console.log('Azurirano je');
      })
    }
  }

  createQuestion(){
    const user = this.loginService.getLoggedInUser();
      this.userService.getUserByUserName(user.username).subscribe((response) =>{
        this.userFromDb = response as User;
        if(user != null){
          const question = {
            text: this.newQuestionText,
            response: '-',
            programm: this.item,
            user: this.userFromDb
          }
    
          this.questionService.createQuestion(question).subscribe((response) =>{
            console.log('Kreirano je');
          })
        }
      })
      
  }
  participate(){
    const user = this.loginService.getLoggedInUser();
    if(user != null){
      this.router.navigate(['/videoPlayer'])
    }
    else
      console.log('Null je');
    
  }
}
