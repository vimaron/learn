package ar.com.ada.learn.model.mapper.circular;

import ar.com.ada.learn.model.dto.CourseDTO;
import ar.com.ada.learn.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseCycleMapper extends DataCycleMapper<CourseDTO, Course> {

    CourseCycleMapper MAPPER = Mappers.getMapper(CourseCycleMapper.class);

}
