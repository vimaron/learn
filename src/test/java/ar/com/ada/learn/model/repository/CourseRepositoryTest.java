package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.CourseMode;
import ar.com.ada.learn.model.entity.TypeOfCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Test
    public void whenSaveThenReturnCourseWhitId(){
        //GIVEN

        Course course = new Course()
                .setName("Test")
                .setPrice(20.0)
                .setHours(10L)
                .setScholarships(5)
                .setCapacity(20)
                .setDescription("descripcion")
                .setCourseMode(new CourseMode("ON-LINE"))
                .setTypeOfCourse(new TypeOfCourse("IT"));
        //WHEN

        //THEN

    }
}