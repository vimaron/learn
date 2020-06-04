package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class RepresentativeDTO {

    private Long id;
    private String name;
    private String lastName;
    private String title;
    private String email;
    private Integer identification;
    private String identificationType;
    private CompanyDTO company;


}
