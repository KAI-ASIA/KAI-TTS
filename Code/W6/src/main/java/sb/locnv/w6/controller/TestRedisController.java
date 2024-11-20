package sb.locnv.w6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.locnv.w6.dto.CustomerTypeDto;
import sb.locnv.w6.exception.DuplicateKeyException;
import sb.locnv.w6.service.ICustomerTypeService;
import sb.locnv.w6.service.impl.RedisService;

import java.util.List;

@RestController
public class TestRedisController {

    @Autowired
    private RedisService redisService;


    @PostMapping("/redisCustomerType")
    public ResponseEntity insertCustomerType(@RequestBody CustomerTypeDto customerType){
        try{
            redisService.put(customerType.getCode(), customerType.getName());
            return ResponseEntity.ok("OK");
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }


    @GetMapping(value = "/redisCustomerType")
    public ResponseEntity getCustomerType(@RequestParam String key){
        Object a = redisService.get(key);

        return ResponseEntity.ok(a);
    }


}
