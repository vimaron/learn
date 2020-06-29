package ar.com.ada.learn.model.dto;

import ar.com.ada.learn.model.entity.Company;
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

    public CompanyDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyDTO setCuil(Long cuil) {
        this.cuil = cuil;
        return this;
    }

    public CompanyDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyDTO setCreation(Year creation) {
        this.creation = creation;
        return this;
    }

    public CompanyDTO setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public CompanyDTO setTypeOfCompanyId(Long typeOfCompanyId) {
        this.typeOfCompanyId = typeOfCompanyId;
        return this;
    }

    public CompanyDTO setCompanyCategoryId(Long companyCategoryId) {
        this.companyCategoryId = companyCategoryId;
        return this;
    }
}
