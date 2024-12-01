package sb.locnv.week9learn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import sb.locnv.week9learn.entity.PartnerConfig;
import sb.locnv.week9learn.repository.PartnerConfigRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class InitOnStartUp {

    @Autowired
    private PartnerConfigRepository partnerConfigRepository;

    @Autowired
    @Qualifier("redisTemplate2Write")
    private RedisTemplate<String, Object> redisTemplate2Write;

    @Autowired
    @Qualifier("redisTemplate2Read")
    private RedisTemplate<String, Object> redisTemplate2Read;

//    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        try{
            initPartners();
            Thread.sleep(5000);
            PartnerConfig p = getPartner("SEABANK");
            System.out.println(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initPartners(){
        List<PartnerConfig> partnerConfigs = partnerConfigRepository.findAll();
        if(partnerConfigs != null && !partnerConfigs.isEmpty()){
            for(PartnerConfig p : partnerConfigs){
                redisTemplate2Write.opsForValue().set(p.getPartnerId(), p, 30, TimeUnit.MINUTES);
            }
        }
    }

    public PartnerConfig getPartner(String partnerId){
        PartnerConfig partnerConfig = null;
        try{
            partnerConfig = (PartnerConfig) redisTemplate2Read.opsForValue().get(partnerId);
            if(partnerConfig == null){
                initPartners();
                Thread.sleep(2000);
            }
            partnerConfig = (PartnerConfig) redisTemplate2Read.opsForValue().get(partnerId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return partnerConfig;
    }

}
