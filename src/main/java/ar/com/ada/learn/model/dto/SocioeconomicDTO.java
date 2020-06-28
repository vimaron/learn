package ar.com.ada.learn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "monthly income is required")
    private Double monthlyIncome;

    @NotBlank(message = "famiy in charge is required")
    private Boolean inChargeOfFamily;

    @NotNull(message = "studentId is required")
    private Long studentId;

    @NotNull(message = "family quantity is required")
    private Integer family;

    private StudentDTO student;

    public SocioeconomicDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public SocioeconomicDTO setStudy(Boolean study) {
        this.study = study;
        return this;
    }

    public SocioeconomicDTO setJob(Boolean job) {
        this.job = job;
        return this;
    }

    public SocioeconomicDTO setIncome(Boolean income) {
        this.income = income;
        return this;
    }

    public SocioeconomicDTO setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
        return this;
    }

    public SocioeconomicDTO setInChargeOfFamily(Boolean inChargeOfFamily) {
        this.inChargeOfFamily = inChargeOfFamily;
        return this;
    }

    public SocioeconomicDTO setStudentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public SocioeconomicDTO setFamily(Integer family) {
        this.family = family;
        return this;
    }

    public SocioeconomicDTO setStudent(StudentDTO student) {
        this.student = student;
        return this;
    }
}
