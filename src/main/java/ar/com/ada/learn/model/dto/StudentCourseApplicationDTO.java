package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentCourseApplicationDTO implements Serializable {

    @NotNull(message = "AdjType is required")
    private String adjType;



}
