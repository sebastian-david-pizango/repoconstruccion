package tarea.basedatos.operaciones.Reseña;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/resena")
public class ControllerResena {

    private final ServiceResena serviceResena;
    private final MapperResena mapperResena;

    public ControllerResena(ServiceResena serviceResena, MapperResena mapperResena) {
        this.serviceResena = serviceResena;
        this.mapperResena = mapperResena;
    }

    @PostMapping("/nuevo")
    public ResponseResena guardarResena(@RequestBody RequestResena nueva) {
        Resena resena = mapperResena.toResena(nueva);
        resena = serviceResena.registrarResena(resena);
        return mapperResena.toResponse(resena);
    }

    @GetMapping("/{id}")
    public ResponseResena consultarResena(@PathVariable int id) {
        return mapperResena.toResponse(serviceResena.consultarResena(id));
    }

    @GetMapping("/pelicula/{peliculaId}")
    public List<ResponseResena> consultarPorPelicula(@PathVariable int peliculaId) {
        return serviceResena.consultarPorPelicula(peliculaId).stream()
                .map(mapperResena::toResponse)
                .toList();
    }
}