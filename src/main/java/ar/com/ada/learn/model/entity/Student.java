package ar.com.ada.learn.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "student")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 50)
    private String gender;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

 //   @ManyToMany
 //      @JoinTable(name = "course_has_student",
 //              joinColumns = @JoinColumn(name = "student_id"),
 //              inverseJoinColumns = @JoinColumn(name = "course_id"))
 //   private Set<Course> courses;

    @OneToOne(mappedBy = "student")
    private SocioEconomic socioEconomic;

    @OneToMany(mappedBy = "student")
    private Set<StudentHasCourse> studentHasCourses;

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }
}
