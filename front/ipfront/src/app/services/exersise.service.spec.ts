import { TestBed } from '@angular/core/testing';

import { ExersiseService } from './exersise.service';

describe('ExersiseService', () => {
  let service: ExersiseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExersiseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
