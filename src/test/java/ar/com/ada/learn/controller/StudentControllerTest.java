package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.SocioeconomicDTO;
import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.entity.Student;
import ar.com.ada.learn.model.repository.StudentRepository;
import ar.com.ada.learn.service.SocioEconomicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired @Qualifier("socioEconomicService")
    private SocioEconomicService socioEconomicService;

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
        String url = "http://localhost:" + port + "/socioEconomics";
        Student newStudent = new Student()
                .setId(5L)
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
                .setStudentId(5l)
                .setJob(true);


        HttpHeaders headers = new HttpHeaders();
        HttpEntity<SocioeconomicDTO> req = new HttpEntity<>(newSocioeconomic);

        ResponseEntity<SocioeconomicDTO> response = testRestTemplate.exchange(
                url, HttpMethod.POST, req, new ParameterizedTypeReference<SocioeconomicDTO>() {
        });

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
    }



}