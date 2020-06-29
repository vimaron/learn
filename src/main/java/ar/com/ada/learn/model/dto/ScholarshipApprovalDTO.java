package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class ScholarshipApprovalDTO implements Serializable {

    @NotNull(message = "approved is required")
    private Boolean approved;

    @NotNull(message = "scholarshipPercentage is requred")
    private Integer scholarshipPercentage;
}
