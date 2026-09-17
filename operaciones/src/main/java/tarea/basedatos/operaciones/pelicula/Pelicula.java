package tarea.basedatos.operaciones.pelicula;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_pelicula")
    @SequenceGenerator(name = "sec_pelicula", sequenceName = "sec_pelicula", allocationSize = 1)
    private int id;

    private String nombre;
    private String autor;
    private String genero;
    private double presupuesto;

    public Pelicula() {
    }

    public Pelicula(int id, String nombre, String autor, String genero, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}