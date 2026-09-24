package relaciones.entity.tarea2.dominio.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_vuelo")
    @SequenceGenerator(
        name = "sec_vuelo",
        sequenceName = "sec_vuelo",
        allocationSize = 1
    )
    private Integer id;

    @Column(name = "fecha_vuelo", nullable = false)
    private LocalDateTime fechaVuelo;

    @Column(nullable = false, length = 100)
    private String origen;

    @Column(nullable = false, length = 100)
    private String destino;

    private double total;

    @OneToMany(
        mappedBy = "vuelo",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<VueloItem> items = new ArrayList<>();

    @PrePersist
    protected void prePersist() {
        if (fechaVuelo == null) {
            fechaVuelo = LocalDateTime.now();
        }
    }

    public void agregarItem(Pasajero pasajero, String asiento, Double precio) {
        VueloItem item = new VueloItem();
        item.setVuelo(this);
        item.setPasajero(pasajero);
        item.setAsiento(asiento);
        item.setPrecio(precio);
        items.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(LocalDateTime fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<VueloItem> getItems() {
        return items;
    }

    public void setItems(List<VueloItem> items) {
        this.items = items;
    }
}