package ar.com.ada.learn.model.entity;

import ar.com.ada.learn.model.dto.CompanyDTO;
import ar.com.ada.learn.model.dto.CourseModeDTO;
import ar.com.ada.learn.model.dto.StudentDTO;
import ar.com.ada.learn.model.dto.TypeOfCourseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "course")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name", length = 50)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "hours", nullable = false)
    private Long hours;

    @Column(name = "scholarships", nullable = false)
    private Long scholarships ;

    @Column(name = "capacity", nullable = false)
    private Long capacity;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "Company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "course_mode_id", referencedColumnName = "id",nullable = false)
    private CourseMode courseMode;

    @ManyToOne
    @JoinColumn(name = "type_of_course_id", referencedColumnName = "id",nullable = false)
    private TypeOfCourse typeOfCourse;

    @OneToMany(mappedBy = "course")
    private Set<StudentHasCourse> studentHasCourses;
}
