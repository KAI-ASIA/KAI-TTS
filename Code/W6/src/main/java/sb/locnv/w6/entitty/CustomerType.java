package sb.locnv.w6.entitty;

import sb.locnv.w6.dto.CustomerTypeDto;

import javax.persistence.*;

@Table(name = "customer_type")
@Entity
public class CustomerType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerType(){}

    public CustomerType(CustomerTypeDto customerTypeDto){
        this.code = customerTypeDto.getCode();
        this.name = customerTypeDto.getName();
    }
}
