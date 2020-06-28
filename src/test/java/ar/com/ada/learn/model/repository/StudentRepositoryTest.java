package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentRepositoryTest {

    @Autowired @Qualifier("studentRepository")
    private StudentRepository studentRepository;

    @Test @Order(0)
    public void whenSaveThenReturnStudentId() {
        Student student = new Student()
                .setName("Vicky")
                .setLastName("Maron")
                .setAddress("casita")
                .setGender("female");

        Student saved = studentRepository.save(student);

        assertNotNull(saved.getId());
    }

    @Test @Order(1)
    public void returnStudentListWhenFindAll(){

        List<Student> studentList = studentRepository.findAll();

        assertThat(studentList).hasSizeGreaterThan(0);
    }









}