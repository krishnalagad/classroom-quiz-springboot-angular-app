import { TestBed } from '@angular/core/testing';

import { RecordsService } from './records.service';

describe('RecordsService', () => {
  let service: RecordsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecordsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
