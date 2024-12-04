package sb.locnv.w10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sb.locnv.w10.entity.PartnerConfig;
import sb.locnv.w10.service.PartnerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partnerConfig")
public class TestController {


    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity createParterConfig(@Valid @RequestBody PartnerConfig partnerConfig, BindingResult result){
        if(result.hasErrors()){
            //Todo
            List<ObjectError> listErrors = result.getAllErrors();
            for (ObjectError error : listErrors){
                System.out.println(error.getObjectName() + "====>" + error.getCode() + ":" + error.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body("validate loi");
        }
        String res = partnerService.insert(partnerConfig);
        if(res == null){
            return ResponseEntity.internalServerError().body("Loi roi");
        }
        return ResponseEntity.ok(res);
    }


    @PostMapping("/upload")
    public ResponseEntity updateFile(@RequestParam("files") MultipartFile file){
        try{
            String name = file.getOriginalFilename();
            System.out.println(name);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
        return ResponseEntity.ok("OK");
    }


}
