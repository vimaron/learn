package ar.com.ada.learn.model.mapper.circular;

import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import org.mapstruct.factory.Mappers;

public interface StudentCycleMapper extends DataCycleMapper<StudentDTO, Student>{

    StudentCycleMapper MAPPER = Mappers.getMapper(StudentCycleMapper.class);
}
