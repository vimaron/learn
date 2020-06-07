package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class CompanyDTO {

    private Long id;
    private String name;
    private Integer cuil;
    private String address;
    private Year creation;
    private String contactNumber;
    private TypeOfCompanyDTO type;
    private CompanyCategoryDTO category;
    private Set<RepresentativeDTO> representatives;
    private Set<CourseDTO> courses;


}
