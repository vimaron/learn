package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class TypeOfCourseDTO {

    private Long id;

    @NotBlank(message = "type is required")
    private String type;
    
    private Set<CourseDTO> courses;
}
