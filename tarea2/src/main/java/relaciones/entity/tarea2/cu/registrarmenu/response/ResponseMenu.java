package relaciones.entity.tarea2.cu.registrarmenu.response;

import java.util.List;

public record ResponseMenu(
    int idMenu,
    String nombre,
    double total,
    List<ResponseMenuItem> items
) {

    public record ResponseMenuItem(
        String nombrePlato,
        int cantidad,
        Double precioUnitario
    ) {
    }
}