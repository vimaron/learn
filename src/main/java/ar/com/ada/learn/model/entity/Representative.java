package ar.com.ada.learn.model.entity;

import ar.com.ada.learn.model.dto.CompanyDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "representative")
public class Representative {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, name = "title", length = 100)
    private String title;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(nullable = false, name = "identification")
    private Integer identification;

    @Column(name = "identification_type", nullable = false)
    private String identificationType;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
