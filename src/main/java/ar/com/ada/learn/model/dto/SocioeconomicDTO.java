package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class SocioeconomicDTO implements Serializable {

    private Long id;

    @NotBlank(message = "study is required")
    private Boolean study;

    @NotBlank(message = "job is required")
    private Boolean job;

    @NotBlank(message = "income is required")
    private Boolean income;

    @NotBlank(message = "monthly income is required")
    private Double monthlyIncome;

    @NotBlank(message = "famiy in charge is required")
    private Boolean inChargeOfFamily;

    @NotBlank(message = "family quantity is required")
    private Integer family;

    private StudentDTO student;


}
