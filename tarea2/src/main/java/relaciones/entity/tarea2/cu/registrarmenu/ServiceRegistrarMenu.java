package relaciones.tarea2.cu.registrarmenu;

import org.springframework.stereotype.Service;
import relaciones.tarea2.cu.registrarmenu.request.RequestMenu;
import relaciones.tarea2.cu.registrarmenu.request.RequestMenu.RequestMenuItem;
import relaciones.tarea2.cu.registrarmenu.response.ResponseMenu;
import relaciones.tarea2.entity.Menu;
import relaciones.tarea2.entity.Plato;
import relaciones.tarea2.repository.RepoMenu;
import relaciones.tarea2.repository.RepoPlato;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRegistrarMenu {

    private final RepoPlato repoPlato;
    private final RepoMenu repoMenu;

    public ServiceRegistrarMenu(RepoPlato repoPlato, RepoMenu repoMenu) {
        this.repoPlato = repoPlato;
        this.repoMenu = repoMenu;
    }

    public ResponseMenu registrarMenu(RequestMenu request) {
        Menu menu = new Menu();
        menu.setNombre(request.nombre());

        double total = 0.0;

        for (RequestMenuItem item : request.items()) {
            Plato plato = repoPlato.findById(item.idPlato())
                    .orElseThrow(() -> new RuntimeException(
                            "Plato no encontrado con id: " + item.idPlato()));

            menu.agregarItem(plato, item.cantidad(), item.precioUnitario());
            total += item.precioUnitario() * item.cantidad();
        }

        menu.setTotal(total);
        repoMenu.save(menu);

        return toResponse(menu);
    }

    public ResponseMenu consultarMenu(int id) {
        Menu menu = repoMenu.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu no encontrado con id: " + id));
        return toResponse(menu);
    }

    public List<ResponseMenu> listarMenus() {
        return repoMenu.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private ResponseMenu toResponse(Menu menu) {
        List<ResponseMenu.ResponseMenuItem> items = menu.getItems().stream()
                .map(i -> new ResponseMenu.ResponseMenuItem(
                        i.getPlato().getNombre(),
                        i.getCantidad(),
                        i.getPrecioUnitario()
                ))
                .toList();

        return new ResponseMenu(
                menu.getId(),
                menu.getNombre(),
                menu.getTotal(),
                items
        );
    }
}