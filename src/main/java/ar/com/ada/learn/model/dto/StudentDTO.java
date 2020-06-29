package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class StudentDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "gender is required")
    private String gender;

    @NotBlank(message = "address is required")
    private String address;

    private Set<CourseDTO> courses;
    private SocioeconomicDTO socioeconomic;

    public StudentDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public StudentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public StudentDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public StudentDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
