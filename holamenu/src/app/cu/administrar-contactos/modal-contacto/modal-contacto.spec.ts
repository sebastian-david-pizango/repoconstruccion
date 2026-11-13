import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ModalContacto } from './modal-contacto';

describe('ModalContacto', () => {
  let component: ModalContacto;
  let fixture: ComponentFixture<ModalContacto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalContacto],
    }).compileComponents();

    fixture = TestBed.createComponent(ModalContacto);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
