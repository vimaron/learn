package ar.com.ada.learn.service;

import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private CycleAvoidingMappingContext context;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void whenFindThenReturnStudentList(){
        Student studentMock = new Student()
                .setId(1l)
                .setName("vic")
                .setLastName("maron")
                .setAddress("casa")
                .setGender("fem");

        Student studentMock2 = new Student()
                .setId(2l)
                .setName("val")
                .setLastName("maron")
                .setAddress("casa")
                .setGender("fem");

        List<Student> studentListMock = Arrays.asList(studentMock, studentMock2);

        when(studentRepository.findAll()).thenReturn(studentListMock);

        List<StudentDTO> studentDTOList = studentService.findAll();

        assertThat(studentDTOList.size()).isEqualTo(2);
        assertThat(studentDTOList.get(0).getName()).isEqualTo("vic");
    }

    @Test
    public void returnStudentSaved(){
        Student studentMock = new Student()
                .setId(1l)
                .setName("lucas")
                .setLastName("maron")
                .setAddress("casa")
                .setGender("masc");

        when(studentRepository.save(any(Student.class))).thenReturn(studentMock);
        StudentDTO dto = new StudentDTO();

        StudentDTO dtoSaved = studentService.save(dto);

        assertThat(dtoSaved.getId()).isEqualTo(1);
    }


}