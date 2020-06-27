package ar.com.ada.learn.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class CourseDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @JsonIgnoreProperties({"courses"})
    private CourseModeDTO courseMode;

    @NotBlank(message = "price is required")
    private Double price;

    @NotBlank(message = "hours is required")
    private Long hours;

    @JsonIgnoreProperties({"courses"})
    private TypeOfCourseDTO typeOfCourse;

    @NotBlank(message = "scholarships is required")
    private Integer scholarships ;

    @NotBlank(message = "direct purchase counter is required")
    private Integer directPurchaseCounter;

    @NotBlank(message = "scholarship counter is required")
    private Integer scholarshipCounter;

    @NotBlank(message = "capacity is required")
    private Integer capacity;

    @NotNull(message = "typeOfCourseId is required")
    private Long typeOfCourseId;

    @NotNull(message = "courseModeId is required")
    private Long courseModeId;

    @NotNull(message = "companyId is required")
    private Long companyId;

    private Set<StudentDTO> students;

    private CompanyDTO company;

    @NotBlank(message = "description is required")
    private String description;



}
