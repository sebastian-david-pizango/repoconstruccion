package pe.edu.uls.demojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface RepositoryRepuesto extends JpaRepository <Repuesto, Integer> {
    List<Repuesto> findByMarca(String marca);
    List<Repuesto> findByNombreContainingIgnoreCase(String texto);
    List<Repuesto> findByNombreContainingIgnoreCaseAndMarcaIgnoreCase( String nombre, String marca );  
    List<Repuesto> findByPrecioLessThan(double precio); 
    List<Repuesto> findByPrecioBetween( double minimo, double maximo ); 
}
