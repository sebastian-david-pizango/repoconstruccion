package relaciones.entity.tarea2.cu.registrarvuelo;

import org.springframework.web.bind.annotation.*;
import relaciones.entity.tarea2.cu.registrarvuelo.request.RequestVuelo;
import relaciones.entity.tarea2.cu.registrarvuelo.response.ResponseVuelo;

import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class ControllerRegistrarVuelo {

    private final ServiceRegistrarVuelo serviceRegistrarVuelo;

    public ControllerRegistrarVuelo(ServiceRegistrarVuelo serviceRegistrarVuelo) {
        this.serviceRegistrarVuelo = serviceRegistrarVuelo;
    }

    @PostMapping("/nuevo")
    public ResponseVuelo guardarVuelo(@RequestBody RequestVuelo request) {
        return serviceRegistrarVuelo.registrarVuelo(request);
    }

    @GetMapping("/todos")
    public List<ResponseVuelo> listarTodos() {
        return serviceRegistrarVuelo.listarVuelos();
    }

    @GetMapping("/{id}")
    public ResponseVuelo consultarVuelo(@PathVariable int id) {
        return serviceRegistrarVuelo.consultarVuelo(id);
    }
}