package sb.locnv.week9learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import sb.locnv.week9learn.entity.PartnerConfig;
import sb.locnv.week9learn.redisrepository.PartnerConfigRedisRepository;

import java.sql.Timestamp;

@Service
public class PartnerService {

    @Autowired
    private PartnerConfigRedisRepository partnerConfigRedisRepository;


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
