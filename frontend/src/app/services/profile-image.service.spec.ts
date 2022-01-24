import { TestBed } from '@angular/core/testing';

import { ProfileImageService } from './profile-image.service';

describe('ProfileImageService', () => {
  let service: ProfileImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfileImageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
