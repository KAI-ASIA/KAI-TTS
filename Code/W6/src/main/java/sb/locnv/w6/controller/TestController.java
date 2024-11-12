package sb.locnv.w6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.locnv.w6.dto.CustomerTypeDto;
import sb.locnv.w6.exception.DuplicateKeyException;
import sb.locnv.w6.service.ICustomerTypeService;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/customerType")
    public ResponseEntity getCustomerType(){
        List<CustomerTypeDto> list = customerTypeService.getCustomerType();

        return ResponseEntity.ok(list);
    }


    @PostMapping("/customerType")
    public ResponseEntity insertCustomerType(@RequestBody CustomerTypeDto customerType){
        try{
            Long id = customerTypeService.insert(customerType);
            return ResponseEntity.ok(id);
        }catch (DuplicateKeyException ex){
            return ResponseEntity.badRequest().body(null);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }


    @PutMapping("/customerType")
    public ResponseEntity updateCustomerType(@RequestBody CustomerTypeDto customerType){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/customerType")
    public ResponseEntity deleteCustomerType(@RequestBody CustomerTypeDto customerType){
        return ResponseEntity.ok(null);
    }

}
