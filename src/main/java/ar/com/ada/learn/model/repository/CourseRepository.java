package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM Course c WHERE Category_id = :categoryId", nativeQuery = true)
    Page<Course> findAllByCategory(@Param("categoryId") Long categoryId, Pageable pageable);

    @Query(value = "SELECT * FROM Course c WHERE Company_id = :companyId", nativeQuery = true)
    Page<Course> findAllByCompany(@Param("companyId") Long companyId, Pageable pageable);


    @Query(value = "SELECT c.* FROM Course c INNER JOIN StudentHasCourse cp ON c.id = cp.course_id WHERE cp.finished = :finished GROUP BY c.id",
                       countQuery = "SELECT DISTINCT COUNT(*) OVER () FROM Course c LEFT JOIN StudentHasCourse cp ON c.id = cp.course_id WHERE cp.finished = :finished GROUP BY c.id;",
                       nativeQuery = true)
     Page<Course> findAllByStudentAndStatus(@Param("finished") Boolean finished, Pageable pageable);



    @Query(value = "SELECT * FROM Course co WHERE co.Company_id = :companyId AND c.Category_id = :categoryId", nativeQuery = true)
    Page<Course> findAllByCompanyAndCategory(@Param("companyId") Long companyId, @Param("categoryId") Long categoryId, Pageable pageable);


}
