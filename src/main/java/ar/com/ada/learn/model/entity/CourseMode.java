package ar.com.ada.learn.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "course_mode")
public class CourseMode {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mode", nullable = false, length = 50)
    private String mode;

    @OneToMany(mappedBy = "courseMode")
    private Set<Course> courses;

}
