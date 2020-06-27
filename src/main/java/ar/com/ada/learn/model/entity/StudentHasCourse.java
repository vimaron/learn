package ar.com.ada.learn.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "student_has_course")
public class StudentHasCourse implements Serializable {

    @EmbeddedId
    private StudentHasCourseId id;

    @Column(name = "adj_type", nullable = false)
    private String adjType;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "finished", nullable = false)
    private Boolean finished;

    @Column(name = "percentage", nullable = false)
    private Integer percentage;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;


    public StudentHasCourse setId(StudentHasCourseId id) {
        this.id = id;
        return this;
    }

    public StudentHasCourse setStudent(Student student) {
        this.student = student;
        return this;
    }
    public StudentHasCourse setCourse(Course course) {
        this.course = course;
        return this;
    }

}
