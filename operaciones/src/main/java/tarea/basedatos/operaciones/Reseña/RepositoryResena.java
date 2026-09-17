package tarea.basedatos.operaciones.Reseña;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryResena extends JpaRepository<Resena, Integer> {

    List<Resena> findByPeliculaIdAndAutor(int peliculaId, String autor);

    List<Resena> findByPeliculaId(int peliculaId);
}