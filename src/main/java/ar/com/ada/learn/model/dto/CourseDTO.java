package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String name;
    private CourseModeDTO mode;
    private Double price;
    private Long hours;
    private TypeOfCourseDTO type;
    private Long scholarships ;
    private Long capacity;
    private Set<StudentDTO> students;
    private CompanyDTO company;
    private String description;


}
