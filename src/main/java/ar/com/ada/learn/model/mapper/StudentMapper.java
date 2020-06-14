package ar.com.ada.learn.model.mapper;

import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.mapper.circular.DataCycleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface StudentMapper extends DataCycleMapper<StudentDTO, Student> {

    Student toEntity(StudentDTO dto);

    StudentDTO toDto(Student entity);

    default Student fromId(Long id) {
        if (id == null) return null;
        return new Student(id);
    }
}
