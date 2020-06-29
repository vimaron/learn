package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import ar.com.ada.learn.model.entity.TypeOfCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {

    //Optional<Course> findByType(TypeOfCourse type);
}
