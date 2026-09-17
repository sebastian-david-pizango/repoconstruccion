package tarea.basedatos.operaciones.Director;

import jakarta.persistence.*;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_director")
    @SequenceGenerator(name = "sec_director", sequenceName = "sec_director", allocationSize = 1)
    private int id;

    private String nombre;
    private String nacionalidad;
    private int aniosExperiencia;

    public Director() {}

    public Director(int id, String nombre, String nacionalidad, int aniosExperiencia) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }
}