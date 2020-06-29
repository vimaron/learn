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
    private String status;

    @Column(name = "percentage", nullable = false)
    private Long percentage;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    private Course course;
}
