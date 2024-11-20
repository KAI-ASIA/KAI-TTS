package sb.locnv.w6.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sb.locnv.w6.dto.CustomerTypeDto;
import sb.locnv.w6.entitty.CustomerType;
import sb.locnv.w6.exception.DuplicateKeyException;
import sb.locnv.w6.repository.CustomerTypeRepository;
import sb.locnv.w6.service.ICustomerTypeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerTypeDto> getCustomerType(Integer page, Integer pageSize) {
        List<CustomerTypeDto> res = new ArrayList<>();

        if(page == null)
            page = 0;

        Page<CustomerType> pages = customerTypeRepository.findAll(PageRequest.of(page, pageSize));

//        List<CustomerType> list = new ArrayList<>();

        if(page != null){
            pages.forEach(x -> res.add(new CustomerTypeDto(x)));
        }

        return  res;
    }


    @Override
    public Long insert(CustomerTypeDto customerType) throws DuplicateKeyException {
        List<CustomerType> isExist = customerTypeRepository.findAllByCode(customerType.getCode());
        if(isExist != null && !isExist.isEmpty()){
            throw new DuplicateKeyException("Code đã tồn tại!");
        }
        CustomerType insert = new CustomerType(customerType);

        return customerTypeRepository.save(insert).getId();
    }
}
