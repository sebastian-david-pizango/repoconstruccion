package tarea.basedatos.operaciones.pelicula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPelicula extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findByAutor(String autor);

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByNombreContainingIgnoreCase(String nombre);

    List<Pelicula> findByPresupuestoLessThan(double presupuesto);

    List<Pelicula> findByPresupuestoBetween(double minimo, double maximo);
    
    List<Pelicula> findByNombreAndAutor(String nombre, String autor);
}
