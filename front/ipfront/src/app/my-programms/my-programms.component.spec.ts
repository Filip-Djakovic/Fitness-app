import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyProgrammsComponent } from './my-programms.component';

describe('MyProgrammsComponent', () => {
  let component: MyProgrammsComponent;
  let fixture: ComponentFixture<MyProgrammsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyProgrammsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyProgrammsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
