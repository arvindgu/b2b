import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoUrlComponent } from './no-url.component';

describe('NoUrlComponent', () => {
  let component: NoUrlComponent;
  let fixture: ComponentFixture<NoUrlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoUrlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoUrlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
