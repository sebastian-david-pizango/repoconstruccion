package relaciones.tarea2.cu.registrarmenu.request;

import java.util.List;

public record RequestMenu(
    String nombre,
    List<RequestMenuItem> items
) {

    public record RequestMenuItem(
        int idPlato,
        int cantidad,
        Double precioUnitario
    ) {
    }
}