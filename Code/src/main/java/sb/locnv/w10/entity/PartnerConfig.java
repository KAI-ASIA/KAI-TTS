package sb.locnv.w10.entity;

import lombok.Data;
import lombok.ToString;
import sb.locnv.w10.validation.ValidPartnerConfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "partner_config")
@Data
@ToString
public class PartnerConfig implements Serializable {

    @org.springframework.data.annotation.Id
    @Id
    @Column(name = "partner_id")
//    @NotBlank(message = "partnerId is required!")
    @ValidPartnerConfig(message = "partnerId is required!")
    private String partnerId;
    @Column(name = "description")
    @Size(min = 2, message = "description is more than 2 characters")
    private String description;
    @Column(name = "nostro_account")
    private String nostroAccount;
    @Column(name = "callback")
    private Boolean callback;
    @Column(name = "time_update")
    private Timestamp timeUpdate;

}
