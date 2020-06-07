package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
