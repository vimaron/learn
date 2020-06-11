package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.Year;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class CompanyDTO {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "cuil is required")
    private Integer cuil;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "creation is required")
    private Year creation;

    @NotBlank(message = "contact number is required")
    private String contactNumber;

    private TypeOfCompanyDTO type;
    private CompanyCategoryDTO category;
    private Set<RepresentativeDTO> representatives;
    private Set<CourseDTO> courses;


}
