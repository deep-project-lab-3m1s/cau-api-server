package cau.cau_be.roadmap.repository;

import cau.cau_be.roadmap.entity.Roadmap;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {

  Optional<Roadmap> findByJobId(Long jobId);
}
