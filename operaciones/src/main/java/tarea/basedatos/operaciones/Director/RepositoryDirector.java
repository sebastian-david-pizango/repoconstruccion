package tarea.basedatos.operaciones.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryDirector extends JpaRepository<Director, Integer> {
    List<Director> findByNombreAndNacionalidad(String nombre, String nacionalidad); // duplicados
    List<Director> findByNacionalidad(String nacionalidad); // consulta por otro campo
}