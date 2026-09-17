package tarea.basedatos.operaciones.Reseña;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_resena")
    @SequenceGenerator(name = "sec_resena", sequenceName = "sec_resena", allocationSize = 1)
    private int id;

    private int peliculaId;
    private String autor;
    private String comentario;
    private int puntuacion;

    public Resena() {
    }

    public Resena(int id, int peliculaId, String autor, String comentario, int puntuacion) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.autor = autor;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}