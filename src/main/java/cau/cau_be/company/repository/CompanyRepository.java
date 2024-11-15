package cau.cau_be.company.repository;

import cau.cau_be.company.entity.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Query("SELECT jc.company FROM JobCompany jc WHERE jc.job.id = :jobId")
  List<Company> findAllByJobId(@Param("jobId") Long jobId);
}
