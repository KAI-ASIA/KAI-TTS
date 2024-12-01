package sb.locnv.week9learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.locnv.week9learn.entity.PartnerConfig;

public interface PartnerConfigRepository extends JpaRepository<PartnerConfig, String> {
}
