package sb.locnv.week9learn.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "partner_config")
@RedisHash("PARTNER_CONFIG")
@Data
@ToString
public class PartnerConfig implements Serializable {

    @org.springframework.data.annotation.Id
    @Id
    @Column(name = "partner_id")
    private String partnerId;
    @Column(name = "description")
    private String description;
    @Column(name = "nostro_account")
    private String nostroAccount;
    @Column(name = "callback")
    private Boolean callback;
    @Column(name = "time_update")
    private Timestamp timeUpdate;

}
