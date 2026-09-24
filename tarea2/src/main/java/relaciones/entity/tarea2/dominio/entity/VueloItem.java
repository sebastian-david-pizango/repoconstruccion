package relaciones.entity.tarea2.dominio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vuelo_item")
public class VueloItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_vuelo_item")
    @SequenceGenerator(
        name = "sec_vuelo_item",
        sequenceName = "sec_vuelo_item",
        allocationSize = 1
    )
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vuelo", nullable = false)
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pasajero", nullable = false)
    private Pasajero pasajero;

    @Column(nullable = false, length = 10)
    private String asiento;

    @Column(nullable = false)
    private Double precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}