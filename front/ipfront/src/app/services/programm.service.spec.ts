import { TestBed } from '@angular/core/testing';

import { ProgrammService } from './programm.service';

describe('ProgrammService', () => {
  let service: ProgrammService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProgrammService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
