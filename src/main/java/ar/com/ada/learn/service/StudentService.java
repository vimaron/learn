package ar.com.ada.learn.service;

import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.mapper.StudentMapper;
import ar.com.ada.learn.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements Services<StudentDTO>{

    private StudentMapper studentMapper = StudentMapper.MAPPER;

    @Autowired @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @Override
    public List<StudentDTO> findAll() {
        List<Student> studentEntityList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = studentMapper.toDto(studentEntityList, context);
        return studentDTOList;
    }

    @Override
    public StudentDTO save(StudentDTO dto) {

        Student studentToSave = studentMapper.toEntity(dto, context);
        Student studentSaved = studentRepository.save(studentToSave);
        StudentDTO studentDTOSaved = studentMapper.toDto(studentSaved, context);
        return studentDTOSaved;
    }

    @Override
    public void delete(Long id) {

    }
}
