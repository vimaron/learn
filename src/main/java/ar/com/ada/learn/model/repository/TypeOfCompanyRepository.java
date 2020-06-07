package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.TypeOfCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typeOfCompanyRepository")
public interface TypeOfCompanyRepository extends JpaRepository<TypeOfCompany, Long> {
}
