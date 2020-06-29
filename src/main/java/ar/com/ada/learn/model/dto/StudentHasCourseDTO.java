package ar.com.ada.learn.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StudentHasCourseDTO {

    @NotBlank(message = "adjType is required")
    private String adjType;

    @NotBlank(message = "status is required")
    private Boolean status;

    @NotBlank(message = "finished is required")
    private Boolean finished;

    @NotBlank(message = "percentaje is required")
    private Integer percentage;

    private StudentDTO student;
    private CourseDTO course;
}
