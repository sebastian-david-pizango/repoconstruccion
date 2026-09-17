package tarea.basedatos.operaciones.pelicula;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperPelicula {

    Pelicula toPelicula(RequestPelicula request);

    ResponsePelicula toResponse(Pelicula pelicula);
}