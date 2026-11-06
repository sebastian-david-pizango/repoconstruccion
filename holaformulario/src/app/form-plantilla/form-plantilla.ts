import { Component } from '@angular/core';
import { NgForm, FormsModule } from '@angular/forms'; 
import { CommonModule } from '@angular/common'; 

@Component({
  selector: 'app-form-plantilla',
  standalone: true,
  imports: [FormsModule, CommonModule], 
  templateUrl: './form-plantilla.html',
  styleUrls: ['./form-plantilla.css']
})
export class FormPlantilla {

  registros: any[] = [];

  onSubmit(form: NgForm) {
    console.log('Se presionó enviar. Formulario válido?', form.valid);
    console.log('Datos:', form.value);

    if (form.valid) {
      this.registros.push({ ...form.value });
      form.resetForm();
    } else {
      Object.values(form.controls).forEach(control => control.markAsTouched());
    }
  }
}