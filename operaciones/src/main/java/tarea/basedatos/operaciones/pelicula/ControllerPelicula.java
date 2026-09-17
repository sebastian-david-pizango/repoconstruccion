package tarea.basedatos.operaciones.pelicula;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController


@RequestMapping("/pelicula")
public class ControllerPelicula {

    private final ServicePelicula servicePelicula;
    private final MapperPelicula mapperPelicula;

    public ControllerPelicula(ServicePelicula servicePelicula, MapperPelicula mapperPelicula) {
        this.servicePelicula = servicePelicula;
        this.mapperPelicula = mapperPelicula;
    }

    @PostMapping("/nuevo")
    public ResponsePelicula guardarPelicula(@RequestBody RequestPelicula nueva) {
        Pelicula pelicula = mapperPelicula.toPelicula(nueva);
        pelicula = servicePelicula.registrarPelicula(pelicula);
        return mapperPelicula.toResponse(pelicula);
    }

    @GetMapping("/todas")
    public List<ResponsePelicula> listarTodas() {
        return servicePelicula.listarPeliculas().stream()
                .map(mapperPelicula::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponsePelicula consultarPelicula(@PathVariable int id) {
        return mapperPelicula.toResponse(servicePelicula.consultarPelicula(id));
    }

    @GetMapping("/autor/{autor}")
    public List<ResponsePelicula> consultarPorAutor(@PathVariable String autor) {
        return servicePelicula.consultarPorAutor(autor).stream()
                .map(mapperPelicula::toResponse)
                .toList();
    }

    @GetMapping("/genero/{genero}")
    public List<ResponsePelicula> consultarPorGenero(@PathVariable String genero) {
        return servicePelicula.consultarPorGenero(genero).stream()
                .map(mapperPelicula::toResponse)
                .toList();
    }

    @GetMapping("/nombre/{nombre}")
    public List<ResponsePelicula> consultarPorNombre(@PathVariable String nombre) {
        return servicePelicula.consultarPorNombre(nombre).stream()
                .map(mapperPelicula::toResponse)
                .toList();
    }

    @GetMapping("/presupuesto/menor/{precio}")
    public List<ResponsePelicula> consultarPorPresupuestoMenor(@PathVariable double precio) {
        return servicePelicula.consultarPorPresupuestoMenor(precio).stream()
                .map(mapperPelicula::toResponse)
                .toList();
    }

    @GetMapping("/presupuesto/rango")
    public List<ResponsePelicula> consultarPorRangoPresupuesto(
            @RequestParam double min,
            @RequestParam double max) {
        return servicePelicula.consultarPorRangoPresupuesto(min, max).stream()
                .map(mapperPelicula::toResponse)
                .toList();
    }
}