package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.model.entity.Course;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface CourseMapper extends DataCycleMapper<CourseDTO, Course> {
    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);

    @InheritInverseConfiguration
    @Mapping(target = "typeOfCourseId", ignore = true)
    @Mapping(target = "courseModeId", ignore = true)
    @Mapping(target = "companyId", ignore = true)
    CourseDTO toDto(Course entity, @Context CycleAvoidingMappingContext context);
}

