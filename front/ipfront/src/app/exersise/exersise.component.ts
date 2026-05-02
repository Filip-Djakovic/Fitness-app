import { Component, OnInit } from '@angular/core';
import { Exersise } from '../model/Exercise';
import { ExersiseService } from '../services/exersise.service';

@Component({
  selector: 'app-exersise',
  templateUrl: './exersise.component.html',
  styleUrls: ['./exersise.component.css']
})
export class ExersiseComponent implements OnInit{

  constructor(private exersiseService: ExersiseService) {}

  ngOnInit(): void {
    this.exersiseService.getAll().subscribe((response) =>{
      this.exercises = response as Exersise[];
    })
  }
  exercises: Exersise[] = []
}
