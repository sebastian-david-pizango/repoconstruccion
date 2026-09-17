package tarea.basedatos.operaciones.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryActor extends JpaRepository<Actor, Integer> {
    List<Actor> findByNombreAndNacionalidad(String nombre, String nacionalidad); // duplicados
    List<Actor> findByNombreContainingIgnoreCase(String nombre); // consulta por otro campo
}