package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.TypeOfCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("typeOfCourseRepository")
public interface TypeOfCourseRepository extends JpaRepository<TypeOfCourse, Long> {
}
