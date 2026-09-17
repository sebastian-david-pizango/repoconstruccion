package tarea.basedatos.operaciones.Actor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ControllerActor {

    private final ServiceActor serviceActor;
    private final MapperActor mapperActor;

    public ControllerActor(ServiceActor serviceActor, MapperActor mapperActor) {
        this.serviceActor = serviceActor;
        this.mapperActor = mapperActor;
    }

    @PostMapping("/nuevo")
    public ResponseActor guardarActor(@RequestBody RequestActor nuevo) {
        Actor actor = mapperActor.toActor(nuevo);
        actor = serviceActor.registrarActor(actor);
        return mapperActor.toResponse(actor);
    }

    @GetMapping("/{id}")
    public ResponseActor consultarActor(@PathVariable int id) {
        return mapperActor.toResponse(serviceActor.consultarActor(id));
    }

    @GetMapping("/nombre/{nombre}")
    public List<ResponseActor> consultarPorNombre(@PathVariable String nombre) {
        return serviceActor.consultarPorNombre(nombre).stream()
                .map(mapperActor::toResponse)
                .toList();
    }
}