package cau.cau_be.tech.repository;

import cau.cau_be.tech.entity.TechSubclass;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechSubclassRepository extends JpaRepository<TechSubclass, Long> {

  List<TechSubclass> findAllByTechId(Long techId);
}
