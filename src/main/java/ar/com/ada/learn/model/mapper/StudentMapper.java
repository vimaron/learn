package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface StudentMapper extends DataCycleMapper<StudentDTO, Student> {
    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

}
