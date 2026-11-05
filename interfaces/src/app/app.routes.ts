import { Routes } from '@angular/router';
import { Home } from './pages/home/home'; 
import { Productos } from './pages/productos/productos'; 
import { NotFound } from './pages/not-found/not-found'; 

export const routes: Routes = [
  { path: '', component: Home, pathMatch: 'full' },
  { path: 'productos', component: Productos },
  { path: '**', component: NotFound }
];