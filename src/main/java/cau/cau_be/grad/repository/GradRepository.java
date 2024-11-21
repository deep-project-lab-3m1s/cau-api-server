package cau.cau_be.grad.repository;

import cau.cau_be.grad.entity.Grad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GradRepository extends JpaRepository<Grad, Long> {

  @Query("SELECT jg.grad FROM JobGrad jg WHERE jg.job.id = :jobId")
  List<Grad> findAllByJobId(@Param("jobId") Long jobId);
}
