package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    private String lastName;
    private String gender;
    private String address;
    private Set<CourseDTO> courses;
    private SocioeconomicDTO socioeconomic;
}
