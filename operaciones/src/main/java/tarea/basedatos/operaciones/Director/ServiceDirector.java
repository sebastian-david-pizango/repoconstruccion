package tarea.basedatos.operaciones.Director;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceDirector {

    private final RepositoryDirector repositoryDirector;

    public ServiceDirector(RepositoryDirector repositoryDirector) {
        this.repositoryDirector = repositoryDirector;
    }

    public Director registrarDirector(Director nuevo) {
        boolean existe = !repositoryDirector
                .findByNombreAndNacionalidad(nuevo.getNombre(), nuevo.getNacionalidad())
                .isEmpty();
        if (existe) {
            throw new DirectorDuplicadoException(
                    "Ya existe un director con nombre '" + nuevo.getNombre() +
                    "' y nacionalidad '" + nuevo.getNacionalidad() + "'");
        }
        return repositoryDirector.save(nuevo);
    }

    public Director consultarDirector(int id) {
        return repositoryDirector.findById(id)
                .orElseThrow(() -> new RuntimeException("Director no encontrado con id: " + id));
    }

    public List<Director> consultarPorNacionalidad(String nacionalidad) {
        return repositoryDirector.findByNacionalidad(nacionalidad);
    }

    public static class DirectorDuplicadoException extends RuntimeException {
        public DirectorDuplicadoException(String mensaje) { super(mensaje); }
    }
}