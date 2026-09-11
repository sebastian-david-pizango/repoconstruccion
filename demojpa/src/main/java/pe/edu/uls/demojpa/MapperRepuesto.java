package pe.edu.uls.demojpa;

import org.mapstruct.Mapper;

@Mapper (componentModel = "spring") 
public interface MapperRepuesto {

    Repuesto toRepuesto(RequestRepuesto nuevo);

    ResponseRepuesto tResponseRepuesto (Repuesto repuesto);

    ResponseRepuesto toRepuesto(Repuesto repuesto);

    ResponseRepuesto toResponse(Repuesto consultarRepuesto);
}
