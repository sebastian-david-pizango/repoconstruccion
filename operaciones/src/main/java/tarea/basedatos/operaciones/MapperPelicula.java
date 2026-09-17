package tarea.basedatos.operaciones;

import org.mapstruct.Mapper;
import tarea.basedatos.operaciones.RequestPelicula;
import tarea.basedatos.operaciones.ResponsePelicula;
import tarea.basedatos.operaciones.Pelicula;

@Mapper(componentModel = "spring")
public interface MapperPelicula {

    Pelicula toPelicula(RequestPelicula request);

    ResponsePelicula toResponse(Pelicula pelicula);
}