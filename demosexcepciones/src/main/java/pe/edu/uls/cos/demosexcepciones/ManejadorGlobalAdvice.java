package pe.edu.uls.cos.demosexcepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ManejadorGlobalAdvice {

    @ExceptionHandler(ProductoInvalidoException.class)
    public ResponseEntity<String> manejarProductoInvalido(ProductoInvalidoException ex) {
        return ResponseEntity .status(HttpStatus.BAD_REQUEST) .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarGenerico(Exception ex) {
        return ResponseEntity .status(HttpStatus.INTERNAL_SERVER_ERROR) .body(ex.getMessage());
    }
}