package relaciones.entity.tarea2.cu.registrarvuelo;

import org.springframework.stereotype.Service;
import relaciones.entity.tarea2.cu.registrarvuelo.request.RequestVuelo;
import relaciones.entity.tarea2.cu.registrarvuelo.request.RequestVuelo.RequestVueloItem;
import relaciones.entity.tarea2.cu.registrarvuelo.response.ResponseVuelo;
import relaciones.entity.tarea2.dominio.entity.Pasajero;
import relaciones.entity.tarea2.dominio.entity.Vuelo;
import relaciones.entity.tarea2.dominio.repository.RepoPasajero;
import relaciones.entity.tarea2.dominio.repository.RepoVuelo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceRegistrarVuelo {

    private final RepoPasajero repoPasajero;
    private final RepoVuelo repoVuelo;

    public ServiceRegistrarVuelo(RepoPasajero repoPasajero, RepoVuelo repoVuelo) {
        this.repoPasajero = repoPasajero;
        this.repoVuelo = repoVuelo;
    }

    public ResponseVuelo registrarVuelo(RequestVuelo request) {
        Vuelo vuelo = new Vuelo();
        vuelo.setOrigen(request.origen());
        vuelo.setDestino(request.destino());

        List<ResponseVuelo.ResponseVueloItem> lstResponse = new ArrayList<>();
        double total = 0.0;

        for (RequestVueloItem item : request.items()) {
            Pasajero pasajero = repoPasajero.findById(item.idPasajero())
                    .orElseThrow(() -> new RuntimeException(
                            "Pasajero no encontrado con id: " + item.idPasajero()));

            vuelo.agregarItem(pasajero, item.asiento(), item.precio());
            total += item.precio();

            lstResponse.add(new ResponseVuelo.ResponseVueloItem(
                    pasajero.getNombre(),
                    item.asiento(),
                    item.precio()
            ));
        }

        vuelo.setTotal(total);
        repoVuelo.save(vuelo);

        return toResponse(vuelo);
    }

    public ResponseVuelo consultarVuelo(int id) {
        Vuelo vuelo = repoVuelo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado con id: " + id));
        return toResponse(vuelo);
    }

    public List<ResponseVuelo> listarVuelos() {
        return repoVuelo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private ResponseVuelo toResponse(Vuelo vuelo) {
        List<ResponseVuelo.ResponseVueloItem> items = vuelo.getItems().stream()
                .map(i -> new ResponseVuelo.ResponseVueloItem(
                        i.getPasajero().getNombre(),
                        i.getAsiento(),
                        i.getPrecio()
                ))
                .toList();

        return new ResponseVuelo(
                vuelo.getId(),
                vuelo.getOrigen(),
                vuelo.getDestino(),
                vuelo.getTotal(),
                items
        );
    }
}