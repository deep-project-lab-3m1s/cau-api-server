package cau.cau_be.tech.repository;

import cau.cau_be.tech.entity.TechDescription;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechDescriptionRepository extends JpaRepository<TechDescription, Long> {

  Optional<TechDescription> findByTechId(Long techId);
}
