import { Component } from '@angular/core';
import { User } from '../model/User';
import { LoginService } from '../services/login.service';
import { UserService } from '../services/user.service';
import { DiaryService } from '../services/diary.service';
import { PdfService } from '../services/pdf.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-diary',
  templateUrl: './diary.component.html',
  styleUrls: ['./diary.component.css']
})
export class DiaryComponent {

  constructor(private loginService: LoginService,
              private userService: UserService,
              private diaryService: DiaryService,
              private pdfService: PdfService,
              private router: Router
  )
  {}


  text: string = '';
  oldWeight: number | null = null;
  newWeight: number | null = null;
  userFromDb: User | undefined;
  userFromDbDownload: User | undefined;
  onUpdateWeight() {
    const userAcc = this.loginService.getLoggedInUser();

    this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
      this.userFromDb = response as User;

      const diary = {
        text: this.text,
        oldWeight: this.oldWeight,
        newWeight: this.newWeight,
        user: this.userFromDb
      }

      this.diaryService.create(diary).subscribe((response) =>{
        console.log('Uspjesno ste kreirali');
      })
    })
  }

  downloadPdf(){
    const userAcc = this.loginService.getLoggedInUser();

    this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
      this.userFromDbDownload = response as User;
      this.pdfService.getById(this.userFromDbDownload.id).subscribe(response => {
        const blob = new Blob([response], { type: 'application/pdf' });
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'output.pdf';
        a.click();
        window.URL.revokeObjectURL(url);
      }, error => {
        console.error('Error downloading the file', error);
      })
    })
  }

  showGraph(){
    this.router.navigate(['/graph'])
  }
}
