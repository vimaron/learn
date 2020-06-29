package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.SocioEconomic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("representativeRepository")
public interface SocioEconomicRepository extends JpaRepository<SocioEconomic, Long> {
}
