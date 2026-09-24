package relaciones.entity.tarea2.dominio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajero")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_pasajero")
    @SequenceGenerator(
        name = "sec_pasajero",
        sequenceName = "sec_pasajero",
        allocationSize = 1
    )
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 20, unique = true)
    private String documento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}