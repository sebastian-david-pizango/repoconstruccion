import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ViewContacto } from './view-contacto';

describe('ViewContacto', () => {
  let component: ViewContacto;
  let fixture: ComponentFixture<ViewContacto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewContacto],
    }).compileComponents();

    fixture = TestBed.createComponent(ViewContacto);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
