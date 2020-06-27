package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.CourseMode;
import ar.com.ada.learn.model.entity.TypeOfCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


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
        Course saved = courseRepository.save(course);

        //THEN

        assertNotNull(saved.getId());

    }

    @Test
    void findAllByCategory() {
        Long categoryId = 1L;

        List<Course> findByCategory = courseRepository.findAllByCategory(categoryId);


    }

    @Test
    void findAllByCompany() {
    }

    @Test
    void findAllByStudentAndStatus() {
    }

    @Test
    void findAllByCompanyAndCategory() {
    }
}