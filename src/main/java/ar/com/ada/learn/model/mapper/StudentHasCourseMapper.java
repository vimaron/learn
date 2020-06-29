package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.StudentHasCourseDTO;
import ar.com.ada.learn.model.entity.StudentHasCourse;
import org.mapstruct.factory.Mappers;

public interface StudentHasCourseMapper extends DataCycleMapper<StudentHasCourseDTO, StudentHasCourse>{
    StudentHasCourseMapper MAPPER = Mappers.getMapper(StudentHasCourseMapper.class);
}
