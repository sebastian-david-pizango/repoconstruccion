package tarea.basedatos.operaciones.Director;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperDirector {
    Director toDirector(RequestDirector request);
    ResponseDirector toResponse(Director director);
}