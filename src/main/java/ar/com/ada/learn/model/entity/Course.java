package ar.com.ada.learn.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
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
    private Integer scholarships ;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(nullable = false, name = "direct_purchase_counter")
    private Integer directPurchaseCounter;

    @Column(nullable = false, name = "scholarship_counter")
    private Integer scholarshipCounter;

    @Column(name = "description", nullable = false, length = 200)
    private String description;

    @Column(name = "status", nullable = false)
    private String status;

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


    public Course setStatus(String status) {
        this.status = status;
        return this;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public Course setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Course setHours(Long hours) {
        this.hours = hours;
        return this;
    }

    public Course setScholarships(Integer scholarships) {
        this.scholarships = scholarships;
        return this;
    }

    public Course setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Course setCourseMode(CourseMode courseMode) {
        this.courseMode = courseMode;
        return this;
    }

    public Course setTypeOfCourse(TypeOfCourse typeOfCourse) {
        this.typeOfCourse = typeOfCourse;
        return this;
    }
}
