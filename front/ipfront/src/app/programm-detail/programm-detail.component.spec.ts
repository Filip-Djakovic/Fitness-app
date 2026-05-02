import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammDetailComponent } from './programm-detail.component';

describe('ProgrammDetailComponent', () => {
  let component: ProgrammDetailComponent;
  let fixture: ComponentFixture<ProgrammDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgrammDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgrammDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
