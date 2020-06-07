package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SocioeconomicDTO {

    private Long id;
    private Boolean study;
    private Boolean job;
    private Boolean income;
    private Double monthlyIncome;
    private Boolean inChargeOfFamily;
    private Integer family;
    private StudentDTO student;


}
