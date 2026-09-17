package tarea.basedatos.operaciones.Actor;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceActor {

    private final RepositoryActor repositoryActor;

    public ServiceActor(RepositoryActor repositoryActor) {
        this.repositoryActor = repositoryActor;
    }

    public Actor registrarActor(Actor nuevo) {
        boolean existe = !repositoryActor
                .findByNombreAndNacionalidad(nuevo.getNombre(), nuevo.getNacionalidad())
                .isEmpty();
        if (existe) {
            throw new ActorDuplicadoException(
                    "Ya existe un actor con nombre '" + nuevo.getNombre() +
                    "' y nacionalidad '" + nuevo.getNacionalidad() + "'");
        }
        return repositoryActor.save(nuevo);
    }

    public Actor consultarActor(int id) {
        return repositoryActor.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado con id: " + id));
    }

    public List<Actor> consultarPorNombre(String nombre) {
        return repositoryActor.findByNombreContainingIgnoreCase(nombre);
    }

    public static class ActorDuplicadoException extends RuntimeException {
        public ActorDuplicadoException(String mensaje) { super(mensaje); }
    }
}