package tarea.basedatos.operaciones.Reseña;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceResena {

    private final RepositoryResena repositoryResena;

    public ServiceResena(RepositoryResena repositoryResena) {
        this.repositoryResena = repositoryResena;
    }

    public Resena registrarResena(Resena nueva) {
        boolean existe = !repositoryResena
                .findByPeliculaIdAndAutor(nueva.getPeliculaId(), nueva.getAutor())
                .isEmpty();
        if (existe) {
            throw new ResenaDuplicadaException(
                    "El autor '" + nueva.getAutor() + "' ya dejó una reseña para la película id " + nueva.getPeliculaId());
        }
        return repositoryResena.save(nueva);
    }

    public Resena consultarResena(int id) {
        return repositoryResena.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada con id: " + id));
    }

    public List<Resena> consultarPorPelicula(int peliculaId) {
        return repositoryResena.findByPeliculaId(peliculaId);
    }

    public static class ResenaDuplicadaException extends RuntimeException {
        public ResenaDuplicadaException(String mensaje) {
            super(mensaje);
        }
    }
}