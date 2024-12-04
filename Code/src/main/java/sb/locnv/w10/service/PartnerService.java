package sb.locnv.w10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import sb.locnv.w10.entity.PartnerConfig;
import sb.locnv.w10.repository.PartnerConfigRepository;

@Service
public class PartnerService {


    @Autowired
    private PartnerConfigRepository partnerConfigRepository;

    public String insert(PartnerConfig partnerConfig){
        try{
            PartnerConfig saved = partnerConfigRepository.save(partnerConfig);
            return saved.getPartnerId();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void doTest(){
        try{
//            PartnerConfig p = new PartnerConfig();
//            p.setPartnerId("KAIASIA");
//            p.setDescription("Cty Kai Asia");
//            p.setCallback(true);
//            p.setNostroAccount("VND123456");
//            p.setTimeUpdate(new Timestamp(System.currentTimeMillis()));
//            partnerConfigRedisRepository.save(p);

//            PartnerConfig p = partnerConfigRedisRepository.findById("KAIASIA").get();
//            System.out.println(p);

//            System.out.println("DONE");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
