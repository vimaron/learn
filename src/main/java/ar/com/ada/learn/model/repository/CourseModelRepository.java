package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.CourseMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseModelRepository")
public interface CourseModelRepository extends JpaRepository<CourseMode, Long> {
}
