package relaciones.entity.tarea2.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relaciones.entity.tarea2.dominio.entity.Vuelo;

public interface RepoVuelo extends JpaRepository<Vuelo, Integer> {
}