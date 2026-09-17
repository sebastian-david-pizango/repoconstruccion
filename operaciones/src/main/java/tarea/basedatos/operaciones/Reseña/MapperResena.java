package tarea.basedatos.operaciones.Reseña;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperResena {

    @Mapping(target = "id", ignore = true)
    Resena toResena(RequestResena request);

    ResponseResena toResponse(Resena resena);
}