package sb.locnv.w6.service;

import sb.locnv.w6.dto.CustomerTypeDto;
import sb.locnv.w6.exception.DuplicateKeyException;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerTypeDto> getCustomerType(Integer page, Integer pageSize);

    Long insert(CustomerTypeDto customerType) throws DuplicateKeyException;
}
