package tarea.basedatos.operaciones;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServicePelicula {

    private final RepositoryPelicula repositoryPelicula;

    public ServicePelicula(RepositoryPelicula repositoryPelicula) {
        this.repositoryPelicula = repositoryPelicula;
    }

    public Pelicula registrarPelicula(Pelicula nueva) {
        return repositoryPelicula.save(nueva);
    }

    public Pelicula consultarPelicula(int id) {
        return repositoryPelicula.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrada con id: " + id));
    }

    public List<Pelicula> listarPeliculas() {
        return repositoryPelicula.findAll();
    }

    public List<Pelicula> consultarPorAutor(String autor) {
        return repositoryPelicula.findByAutor(autor);
    }

    public List<Pelicula> consultarPorGenero(String genero) {
        return repositoryPelicula.findByGenero(genero);
    }

    public List<Pelicula> consultarPorNombre(String nombre) {
        return repositoryPelicula.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Pelicula> consultarPorPresupuestoMenor(double presupuesto) {
        return repositoryPelicula.findByPresupuestoLessThan(presupuesto);
    }

    public List<Pelicula> consultarPorRangoPresupuesto(double min, double max) {
        return repositoryPelicula.findByPresupuestoBetween(min, max);
    }
}