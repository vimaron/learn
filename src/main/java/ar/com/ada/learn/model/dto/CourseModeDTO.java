package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class CourseModeDTO {

    private Long id;
    private String mode;
    private Set<CourseDTO> courses;

    public CourseModeDTO(Long id, String mode) {
        this.id = id;
        this.mode = mode;
    }

    public CourseModeDTO(String mode) {
        this.mode = mode;
    }
}