import { Component } from '@angular/core';
import { ModalContacto } from '../modal-contacto/modal-contacto';

@Component({
  imports: [],
  selector: 'app-view-contacto',
  styleUrl: './view-contacto.css',
  templateUrl: './view-contacto.html',
})
export class ViewContacto {
 contactos: any[] = [
    { id: 1, nombre: 'Jose', cargo: "Gerente", horario: "Mañana" },
    { id: 2, nombre: 'Pablo', cargo: "Contable", horario: "Tarde" },
    { id: 3, nombre: 'Jorge', cargo: "Administrador en ventas", horario: "Tarde" },
    { id: 4, nombre: 'Sonia', cargo: "Gerente Recursos humanos", horario: "Mañana" }
  ];

}
