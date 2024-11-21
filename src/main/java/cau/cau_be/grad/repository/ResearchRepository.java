package cau.cau_be.grad.repository;

import cau.cau_be.grad.entity.Research;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResearchRepository extends JpaRepository<Research, Long> {

  @Query("SELECT jr.research FROM JobResearch jr WHERE jr.job.id = :jobId")
  List<Research> findAllByJobId(@Param("jobId") Long jobId);
}
