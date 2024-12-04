package sb.locnv.w10.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RunEverySecond {

    @Scheduled(fixedDelay = 3000)
    public void doTest(){
        System.out.println("Bay gio la : " + new Date(System.currentTimeMillis()));
    }

}
