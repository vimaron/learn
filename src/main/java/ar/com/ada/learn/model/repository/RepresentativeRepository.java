package ar.com.ada.learn.model.repository;

import ar.com.ada.learn.model.entity.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("representativeRepository")
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {
}
