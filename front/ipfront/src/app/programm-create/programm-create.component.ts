import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Category } from '../model/Category';
import { Instructor } from '../model/Instructor';
import { Location } from '../model/Location';
import { LocationService } from '../services/location.service';
import { InstructorService } from '../services/instructor.service';
import { CetegoryService } from '../services/cetegory.service';
import { ProgrammService } from '../services/programm.service';
import { UserService } from '../services/user.service';
import { LoginService } from '../services/login.service';
import { User } from '../model/User';

@Component({
  selector: 'app-programm-create',
  templateUrl: './programm-create.component.html',
  styleUrls: ['./programm-create.component.css']
})
export class ProgrammCreateComponent {
  programmsForm!: FormGroup;
  categories: Category[] = [];
  locations: Location[] = [];
  instructors: Instructor[] = [];
  selectedFileBase64!: string
  userFromDb!: User;
  constructor(private fb: FormBuilder,
              private locationService: LocationService,
              private instructorService: InstructorService,
              private categoryService: CetegoryService,
              private programmService: ProgrammService,
              private userService: UserService,
              private loginService: LoginService
  ) {}

  ngOnInit(): void {
    // Initialize the form
    this.programmsForm = this.fb.group({
      name: [''],
      price: [''],
      level: [''],
      time: [''],
      description: [''],
      contact: [''],
      category: [''],
      location: [''],
      instructor: ['']
    });

    this.locationService.getAll().subscribe((response) =>{
      this.locations = response as Location[];
    })
    this.categoryService.getAll().subscribe((response) =>{
      this.categories = response as Category[];
    })
    this.instructorService.getAll().subscribe((response) =>{
      this.instructors = response as Instructor[];
    })
    
  }

  onFileSelected(event: any): void {
    const file: File = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = () => {
        this.selectedFileBase64 = reader.result as string;
        this.programmsForm.patchValue({
          picture: this.selectedFileBase64.split(',')[1]
        });
      };
      reader.readAsDataURL(file);
    }
  }

  onSubmit(): void {
    if (this.programmsForm.valid) {
      const programmsData = this.programmsForm.value;
      programmsData.picture = this.selectedFileBase64.split(',')[1]
      programmsData.isActivated = 0;
      programmsData.isFinished = 0;
      programmsData.isParticipated = 0;
      const userAcc = this.loginService.getLoggedInUser();
      this.userService.getUserByUserName(userAcc.username).subscribe((response) =>{
        this.userFromDb = response as User;
        programmsData.user = this.userFromDb;

      this.programmService.createProgramm(programmsData).subscribe((response) =>{
        console.log('Uspjesno ste kreirali program');
      })
    
    })
    console.log(programmsData);
    }
  }
}
