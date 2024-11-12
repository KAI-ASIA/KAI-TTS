package sb.locnv.w6.dto;

import sb.locnv.w6.entitty.CustomerType;

public class CustomerTypeDto {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerTypeDto(){}


    public CustomerTypeDto(CustomerType customerType){
        this.name = customerType.getName();
        this.code = customerType.getCode();
    }

}
