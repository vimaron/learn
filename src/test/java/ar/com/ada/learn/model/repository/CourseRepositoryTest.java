package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.CourseMode;
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

        Course course = new Course().builder().name("Test").price(20.0).hours(10).scholarships(5)
                .capacity(20).description("descripcion").courseMode().typeOfCourse().build();
        //WHEN

        //THEN

    }
}