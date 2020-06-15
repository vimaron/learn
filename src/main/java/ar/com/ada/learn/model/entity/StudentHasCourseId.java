package ar.com.ada.learn.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@Embeddable
public class StudentHasCourseId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    public StudentHasCourseId setStudentId(Long studentId){
        this.studentId = studentId;
        return this;
    }

    public StudentHasCourseId setCourseId(Long courseId){
        this.courseId = courseId;
        return this;
    }

}
