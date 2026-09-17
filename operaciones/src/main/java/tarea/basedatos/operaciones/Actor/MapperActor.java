package tarea.basedatos.operaciones.Actor;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperActor {
    Actor toActor(RequestActor request);
    ResponseActor toResponse(Actor actor);
}