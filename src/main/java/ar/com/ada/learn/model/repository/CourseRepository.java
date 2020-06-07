package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {
}
