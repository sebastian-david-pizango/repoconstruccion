package relaciones.tarea2.cu.registrarvuelo.request;

import java.util.List;

public record RequestVuelo(
    String origen,
    String destino,
    List<RequestVueloItem> items
) {

    public record RequestVueloItem(
        int idPasajero,
        String asiento,
        Double precio
    ) {
    }
}