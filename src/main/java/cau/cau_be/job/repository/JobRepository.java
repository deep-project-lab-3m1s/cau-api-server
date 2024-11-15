package cau.cau_be.job.repository;

import cau.cau_be.job.entity.Job;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Long> {

  @Query("SELECT j FROM Job j JOIN j.jobSubjects js WHERE js.subject.id IN :subjectIds")
  List<Job> findAllBySubjectIds(@Param("subjectIds") List<Long> subjectIds);
}
