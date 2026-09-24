package relaciones.tarea2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relaciones.tarea2.entity.Pasajero;

public interface RepoPasajero extends JpaRepository<Pasajero, Integer> {
}