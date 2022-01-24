import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadQuizComponent } from './load-quiz.component';

describe('LoadQuizComponent', () => {
  let component: LoadQuizComponent;
  let fixture: ComponentFixture<LoadQuizComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoadQuizComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
