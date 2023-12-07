import { TestBed } from '@angular/core/testing';

import { StudentRestService } from './student-rest.service';

describe('StudentRestService', () => {
  let service: StudentRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudentRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
