package relaciones.tarea2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relaciones.tarea2.entity.Menu;

public interface RepoMenu extends JpaRepository<Menu, Integer> {
}