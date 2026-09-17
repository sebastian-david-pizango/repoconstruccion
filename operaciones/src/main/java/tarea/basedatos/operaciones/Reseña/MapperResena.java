package tarea.basedatos.operaciones.Reseña;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperResena {
    Resena toResena(RequestResena request);
    ResponseResena toResponse(Resena resena);
}