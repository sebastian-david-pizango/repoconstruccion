package relaciones.entity.tarea2.dominio.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_menu")
    @SequenceGenerator(
        name = "sec_menu",
        sequenceName = "sec_menu",
        allocationSize = 1
    )
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_menu", nullable = false)
    private LocalDate fechaMenu;

    private double total;

    @OneToMany(
        mappedBy = "menu",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<MenuItem> items = new ArrayList<>();

    @PrePersist
    protected void prePersist() {
        if (fechaMenu == null) {
            fechaMenu = LocalDate.now();
        }
    }

    public void agregarItem(Plato plato, int cantidad, Double precioUnitario) {
        MenuItem item = new MenuItem();
        item.setMenu(this);
        item.setPlato(plato);
        item.setCantidad(cantidad);
        item.setPrecioUnitario(precioUnitario);
        items.add(item);
    }

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

    public LocalDate getFechaMenu() {
        return fechaMenu;
    }

    public void setFechaMenu(LocalDate fechaMenu) {
        this.fechaMenu = fechaMenu;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
}