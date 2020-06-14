package ar.com.ada.learn.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "company")
@Builder
public class Company {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "cuil", nullable = false, length = 11)
    private Integer cuil;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

   @Column(name = "creation", nullable = false)
    private Year creation;

    @Column(name = "contact_number", nullable = false, length = 10)
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "company_category_id", referencedColumnName = "id", nullable = false)
    private CompanyCategory companyCategory;

    @OneToMany(mappedBy = "company")
    private Set<Representative> representatives;

    @OneToMany(mappedBy = "company")
    private Set<Course> courses;

    @ManyToOne
    @JoinColumn(name = "type_of_company_id", referencedColumnName = "id",nullable = false)
    private TypeOfCompany typeOfCompany;

    public Company(Long id) {
    }
}
