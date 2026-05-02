import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Chart, registerables } from 'chart.js'
import { LoginService } from '../services/login.service';
import { UserService } from '../services/user.service';
import { User } from '../model/User';
@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.css']
})
export class GraphComponent implements OnInit{

  chart: any;
  userFromDb : User | undefined
  constructor(private http: HttpClient,
              private loginService: LoginService,
              private userService: UserService
  ){}
  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(): void {
    const url = 'http://localhost:8080/diarys/weights/';
    const userAcc = this.loginService.getLoggedInUser();

    this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
      this.userFromDb = response as User;
      const newUrl = url+this.userFromDb.id;
    this.http.get<number[]>(newUrl).subscribe(data => {
      this.createChart(data);
    });

  });
  }

  createChart(data: number[]): void {
    Chart.register(...registerables);

    this.chart = new Chart('myChart', {
      type: 'line',
      data: {
        labels: data.map((_, index) => `Time ${index + 1}`),
        datasets: [{
          label: 'Values over Time',
          data: data,
          borderColor: 'rgba(75, 192, 192, 1)',
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
        }]
      },
      options: {
        responsive: true,
        scales: {
          x: {
            beginAtZero: true
          },
          y: {
            beginAtZero: true
          }
        }
      }
    });
  }
}
