package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class CourseDTO {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    private CourseModeDTO mode;

    @NotBlank(message = "price is required")
    private Double price;

    @NotBlank(message = "hours is required")
    private Long hours;

    private TypeOfCourseDTO type;

    @NotBlank(message = "scholarships is required")
    private Long scholarships ;

    @NotBlank(message = "capacity is required")
    private Long capacity;
    private Set<StudentDTO> students;
    private CompanyDTO company;

    @NotBlank(message = "description is required")
    private String description;



}
