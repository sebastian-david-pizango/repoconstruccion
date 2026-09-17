package tarea.basedatos.operaciones.Reseña;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepositoryResena extends JpaRepository<Resena, Integer> {
    List<Resena> findByPeliculaIdAndAutor(int peliculaId, String autor); // duplicados (un autor, una reseña por película)
    List<Resena> findByPeliculaId(int peliculaId); // consulta por otro campo
}