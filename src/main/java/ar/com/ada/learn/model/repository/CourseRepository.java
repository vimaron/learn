package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM Course c WHERE c.categoryId = :categoryId", nativeQuery = true)
    List<Course> findAllByCategory(@Param("category") Long categoryId);

    @Query(value = "SELECT * FROM Course c WHERE c.company = :company", nativeQuery = true)
    List<Course> findAllByCompany(@Param("company") Long companyId);

    @Query(value = "SELECT * FROM Course s WHERE s.student = :student AND isc = isc.status")
    List<Course> findAllByStudentAndStatus(@Param("studentId") Long studentId, @Param("isClosed") String isClosed);

    @Query(value = "SELECT * FROM Course co WHERE co.companyId = :companyId AND c = c.categoryId")
    List<Course> findAllByCompanyAndCategory(@Param("companyId") Long companyId, @Param("categoryId") Long categoryId);
    //Optional<Course> findByType(TypeOfCourse type);
}
