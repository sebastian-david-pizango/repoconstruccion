package tarea.basedatos.operaciones.Director;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/director")
public class ControllerDirector {

    private final ServiceDirector serviceDirector;
    private final MapperDirector mapperDirector;

    public ControllerDirector(ServiceDirector serviceDirector, MapperDirector mapperDirector) {
        this.serviceDirector = serviceDirector;
        this.mapperDirector = mapperDirector;
    }

    @PostMapping("/nuevo")
    public ResponseDirector guardarDirector(@RequestBody RequestDirector nuevo) {
        Director director = mapperDirector.toDirector(nuevo);
        director = serviceDirector.registrarDirector(director);
        return mapperDirector.toResponse(director);
    }

    @GetMapping("/{id}")
    public ResponseDirector consultarDirector(@PathVariable int id) {
        return mapperDirector.toResponse(serviceDirector.consultarDirector(id));
    }

    @GetMapping("/nacionalidad/{nacionalidad}")
    public List<ResponseDirector> consultarPorNacionalidad(@PathVariable String nacionalidad) {
        return serviceDirector.consultarPorNacionalidad(nacionalidad).stream()
                .map(mapperDirector::toResponse)
                .toList();
    }
}