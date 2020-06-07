package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.StudentHasCourse;
import ar.com.ada.learn.model.entity.StudentHasCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentHasCourseRepository")
public interface StudentHasCourseRepository extends JpaRepository<StudentHasCourse, StudentHasCourseId> {
}
