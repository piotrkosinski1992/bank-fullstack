import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExternalPaymentComponent } from './external-payment.component';

describe('ExternalPaymentComponent', () => {
  let component: ExternalPaymentComponent;
  let fixture: ComponentFixture<ExternalPaymentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExternalPaymentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExternalPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
