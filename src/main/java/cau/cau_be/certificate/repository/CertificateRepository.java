package cau.cau_be.certificate.repository;

import cau.cau_be.certificate.entity.Certificate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {

  List<Certificate> findAllByTechId(Long techId);
}
