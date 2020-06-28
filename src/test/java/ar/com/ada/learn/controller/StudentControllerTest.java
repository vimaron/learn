package ar.com.ada.learn.controller;

import ar.com.ada.learn.model.dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

}