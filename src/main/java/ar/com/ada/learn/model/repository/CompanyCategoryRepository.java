package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companyCategoryRepository")
public interface CompanyCategoryRepository extends JpaRepository<CompanyCategory, Long> {
}
