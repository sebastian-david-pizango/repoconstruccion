package relaciones.entity.tarea2.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relaciones.entity.tarea2.dominio.entity.Plato;

public interface RepoPlato extends JpaRepository<Plato, Integer> {
}