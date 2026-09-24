package relaciones.tarea2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relaciones.tarea2.entity.Plato;

public interface RepoPlato extends JpaRepository<Plato, Integer> {
}