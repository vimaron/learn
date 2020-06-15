package ar.com.ada.learn.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDTO implements Serializable {

    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "cuil is required")
    private Long cuil;

    @NotBlank(message = "address is required")
    private String address;

    @NotNull(message = "creation is required")
    private Year creation;

    @NotBlank(message = "contact number is required")
    private String contactNumber;

    @NotNull(message = "typeOfCompanyId is required")
    private Long typeOfCompanyId;

    @NotNull(message = "companyCategoryId is required")
    private Long companyCategoryId;

    @JsonIgnoreProperties({"companies"})
    private TypeOfCompanyDTO typeOfCompany;

    @JsonIgnoreProperties({"companies"})
    private CompanyCategoryDTO companyCategory;

    private Set<RepresentativeDTO> representatives;
    private Set<CourseDTO> courses;


}
