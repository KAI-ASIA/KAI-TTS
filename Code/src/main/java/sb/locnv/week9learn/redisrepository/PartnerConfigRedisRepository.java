package sb.locnv.week9learn.redisrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.locnv.week9learn.entity.PartnerConfig;

public interface PartnerConfigRedisRepository extends JpaRepository<PartnerConfig, String> {
}
