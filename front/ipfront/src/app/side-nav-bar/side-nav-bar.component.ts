import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-side-nav-bar',
  templateUrl: './side-nav-bar.component.html',
  styleUrls: ['./side-nav-bar.component.css']
})
export class SideNavBarComponent {

  constructor(private router: Router,
              private loginService: LoginService
  ){
    
  }

  goTo(paramText: string) {
    this.router.navigate([paramText]);
  }
  logout(){
    this.loginService.logoutUser();
    this.router.navigate(['/']);
  }

}
