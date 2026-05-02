import { Component, OnInit, ViewChild } from '@angular/core';
import { Programm } from '../model/Programm';
import { ProgrammService } from '../services/programm.service';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
@Component({
  selector: 'app-programms',
  templateUrl: './programms.component.html',
  styleUrls: ['./programms.component.css']
})
export class ProgrammsComponent implements OnInit{
  constructor(private programmService: ProgrammService,
              private router: Router
  ) {}
  ngOnInit(): void {
    this.programmService.getProgramms().subscribe((response) =>{
      this.items = response as Programm[];
      this.allItems = this.items;
      this.updatePagedItems();
    })
  }
  items: Programm[] = [];
  pagedItems: any[] = []; // Prikazani podaci na stranici
  allItems: Programm[] = [];
  pageSize = 10; // Broj stavki po stranici
  pageSizeOptions: number[] = [5, 10, 20];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  details(item: any){
    this.router.navigate(['/programmDetail', item.id])
  }

  applyFilter(event: KeyboardEvent): void {
    const target = event.target as HTMLInputElement;
    const filterValue = target.value.trim().toLowerCase();
    console.log(filterValue);
    this.pagedItems = this.items.filter(item =>
      item.name.toLowerCase().includes(filterValue) ||
      item.description.toLowerCase().includes(filterValue)
    );
    this.items = this.pagedItems;
    if(filterValue === ''){
      this.items = this.allItems;
    }
    this.updatePagedItems();
  }

  onPageChange(event: any): void {
    this.updatePagedItems();
  }

  updatePagedItems(): void {
    const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
    const endIndex = startIndex + this.paginator.pageSize;
    this.pagedItems = this.items.slice(startIndex, endIndex);
  }

  deleteItem(item: any, event: MouseEvent){
    /*event.stopPropagation();
    this.programmService.deleteProgram(item.id).subscribe((response) =>{
      console.log(response);
    })
   console.log(item);*/
  }
}
