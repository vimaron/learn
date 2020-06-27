package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CourseHasFinishedDTO implements Serializable {

    @NotNull(message = "courseFinished is required")
    private Boolean courseFinished;
}
