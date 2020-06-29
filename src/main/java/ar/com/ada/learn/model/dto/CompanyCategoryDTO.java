package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CompanyCategoryDTO implements Serializable {

    private Long id;

    @NotBlank(message = "category is required")
    private String category;

    private Set<CompanyDTO> companies;
}
