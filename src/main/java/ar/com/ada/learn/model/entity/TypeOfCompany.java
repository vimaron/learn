package ar.com.ada.learn.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "type_of_company")
public class TypeOfCompany {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    @OneToMany(mappedBy = "typeOfCompany")
    private Set<Company> companies;

    public TypeOfCompany(String type) {
        this.type = type;
    }
}
