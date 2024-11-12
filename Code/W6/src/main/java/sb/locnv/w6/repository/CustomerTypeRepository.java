package sb.locnv.w6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.locnv.w6.entitty.CustomerType;

import java.util.List;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {

    List<CustomerType> findAllByCode(String code);

}
