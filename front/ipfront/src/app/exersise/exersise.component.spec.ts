import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExersiseComponent } from './exersise.component';

describe('ExersiseComponent', () => {
  let component: ExersiseComponent;
  let fixture: ComponentFixture<ExersiseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExersiseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExersiseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
