package tarea.basedatos.operaciones.Actor;

import jakarta.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_actor")
    @SequenceGenerator(name = "sec_actor", sequenceName = "sec_actor", allocationSize = 1)
    private int id;

    private String nombre;
    private String nacionalidad;
    private int edad;

    public Actor() {}

    public Actor(int id, String nombre, String nacionalidad, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}