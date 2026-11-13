import { Routes } from '@angular/router';
import { ViewProductos } from './cu/administrar-productos/view-productos/view-productos';
import { ViewContacto } from './cu/administrar-contactos/view-contacto/view-contacto';

export const routes: Routes = [
    {
        path:'productos', component: ViewProductos,title  :'Vista de productos'
    },
    {
        path:'contactos', component: ViewContacto,title  :'Vista de contactos'
    }
];

  