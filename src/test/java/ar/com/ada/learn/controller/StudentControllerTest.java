package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.learn.model.mapper.StudentMapper;
import ar.com.ada.learn.model.repository.StudentRepository;
import ar.com.ada.learn.service.SocioEconomicService;
import ar.com.ada.learn.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @Autowired
    @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    @LocalServerPort
    private int port;

    private StudentMapper studentMapper = StudentMapper.MAPPER;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired @Qualifier("studentService")
    private StudentService studentService;


    @Autowired @Qualifier("studentRepository")
    private StudentRepository studentRepository;


    @Test
    public void newStudentShouldBeCreated(){
        String url = "http://localhost:" + port + "/students";

        StudentDTO newStudent = new StudentDTO()
                .setName("Vicky")
                .setLastName("Maron")
                .setAddress("casita")
                .setGender("female");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<StudentDTO> req = new HttpEntity<>(newStudent);

        ResponseEntity<StudentDTO> response = testRestTemplate.exchange(
               url, HttpMethod.POST, req, new ParameterizedTypeReference<StudentDTO>() {
                }
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    public void newSocioEcnomicShouldBeCreated(){
        String url = "http://localhost:" + port + "/students/socioEconomic";
        Student newStudent = new Student()
                .setName("Alejandr")
                .setLastName("Maron")
                .setAddress("casita")
                .setGender("male");

        studentRepository.save(newStudent);

        SocioeconomicDTO newSocioeconomic = new SocioeconomicDTO()
                .setFamily(3)
                .setInChargeOfFamily(true)
                .setIncome(true)
                .setMonthlyIncome(40000.00)
                .setStudy(true)
                .setStudentId(1l)
                .setJob(true);


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<SocioeconomicDTO> req = new HttpEntity<>(newSocioeconomic);

        ResponseEntity<SocioeconomicDTO> response = testRestTemplate.exchange(
                url, HttpMethod.POST, req, new ParameterizedTypeReference<SocioeconomicDTO>() {
        });

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    public void returnStudentListWhenFindAll(){
        StudentDTO studentMock = new StudentDTO()
                .setId(1l)
                .setName("vic")
                .setLastName("maron")
                .setAddress("casa")
                .setGender("fem");

        StudentDTO studentMock2 = new StudentDTO()
                .setId(2l)
                .setName("val")
                .setLastName("maron")
                .setAddress("casa")
                .setGender("fem");

        Student studentToSave = studentMapper.toEntity(studentMock, context);
        Student studentToSave2 = studentMapper.toEntity(studentMock2, context);

        studentRepository.save(studentToSave);
        studentRepository.save(studentToSave2);

        List<StudentDTO> studentList = studentService.findAll();

        assertThat(studentList.size()).isEqualTo(2);

    }


}