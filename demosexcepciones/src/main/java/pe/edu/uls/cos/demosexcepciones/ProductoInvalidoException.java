package pe.edu.uls.cos.demosexcepciones;

public class ProductoInvalidoException extends RuntimeException {

    public ProductoInvalidoException(String msg) {
        super(msg);
    }
}
