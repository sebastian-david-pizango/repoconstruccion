package relaciones.tarea2.cu.registrarvuelo.response;

import java.util.List;

public record ResponseVuelo(
    int idVuelo,
    String origen,
    String destino,
    double total,
    List<ResponseVueloItem> items
) {

    public record ResponseVueloItem(
        String nombrePasajero,
        String asiento,
        Double precio
    ) {
    }
}