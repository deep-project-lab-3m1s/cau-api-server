package cau.cau_be.startup.repository;

import cau.cau_be.startup.entity.StartupCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartupCertificateRepository extends JpaRepository<StartupCertificate, Long> {

}
