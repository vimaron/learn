package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.SocioEconomic;
import ar.com.ada.learn.model.entity.Student;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface SocioeconomicMapper extends DataCycleMapper <SocioeconomicDTO, SocioEconomic>{
    SocioeconomicMapper MAPPER = Mappers.getMapper(SocioeconomicMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "studentId", ignore = true)
    StudentDTO toDto(Student entity, @Context CycleAvoidingMappingContext context);
}
