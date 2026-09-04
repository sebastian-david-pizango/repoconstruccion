package pe.edu.uls.cos.demosexcepciones;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service 
public class ServiceProductos {

    public Producto registrarProducto(Producto nuevo) {
        if (nuevo.getNombre().length()<2) {
            throw new ProductoInvalidoException("El producto debe tener un nombre de al menos dos caracteres");
        }
        if (nuevo.getNombre().equals("mouse")) {
            throw new ProductoRepetidoException("El producto ya existe");
        }
        Date ahora = new Date();
        nuevo.setId((int) ahora.getTime());
        return nuevo;
    }
}

