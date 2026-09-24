package relaciones.tarea2.cu.registrarmenu;

import org.springframework.web.bind.annotation.*;
import relaciones.tarea2.cu.registrarmenu.request.RequestMenu;
import relaciones.tarea2.cu.registrarmenu.response.ResponseMenu;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class ControllerRegistrarMenu {

    private final ServiceRegistrarMenu serviceRegistrarMenu;

    public ControllerRegistrarMenu(ServiceRegistrarMenu serviceRegistrarMenu) {
        this.serviceRegistrarMenu = serviceRegistrarMenu;
    }

    @PostMapping("/nuevo")
    public ResponseMenu guardarMenu(@RequestBody RequestMenu request) {
        return serviceRegistrarMenu.registrarMenu(request);
    }

    @GetMapping("/todos")
    public List<ResponseMenu> listarTodos() {
        return serviceRegistrarMenu.listarMenus();
    }

    @GetMapping("/{id}")
    public ResponseMenu consultarMenu(@PathVariable int id) {
        return serviceRegistrarMenu.consultarMenu(id);
    }
}