package cau.cau_be.tech.repository;

import cau.cau_be.tech.entity.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<Tech, Long> {

}
