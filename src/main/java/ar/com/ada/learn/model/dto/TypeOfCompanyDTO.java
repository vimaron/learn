package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class TypeOfCompanyDTO {

    private Long id;
    private String type;
    private Set<CompanyDTO> companies;

}
