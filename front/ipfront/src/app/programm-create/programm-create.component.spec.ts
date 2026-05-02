import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammCreateComponent } from './programm-create.component';

describe('ProgrammCreateComponent', () => {
  let component: ProgrammCreateComponent;
  let fixture: ComponentFixture<ProgrammCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgrammCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProgrammCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
