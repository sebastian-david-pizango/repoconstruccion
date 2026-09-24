package relaciones.tarea2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relaciones.tarea2.entity.Vuelo;

public interface RepoVuelo extends JpaRepository<Vuelo, Integer> {
}