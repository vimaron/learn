package ar.com.ada.learn.model.entity;


import ar.com.ada.learn.model.dto.StudentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "socioeconomic")
public class SocioEconomic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "study", nullable = false)
    private Boolean study;

    @Column(name = "job", nullable = false)
    private Boolean job;

    @Column(name = "income", nullable = false)
    private Boolean income;

    @Column(name = "monthly_income", nullable = false)
    private Double monthlyIncome;

    @Column(name = "in_charge_of_family", nullable = false)
    private Boolean inChargeOfFamily;

    @Column(name = "family", nullable = false)
    private Integer family;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;

}
