package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class RepresentativeDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "identification is required")
    private Integer identification;

    @NotNull(message = "companyId is required")
    private Long companyId;

    private String identificationType;
    private CompanyDTO company;


}
