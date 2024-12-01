package sb.locnv.week9learn.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitThreadPoll {

    @Autowired
    private ApplicationContext applicationContext;


    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        try{
            ThreadPollKafkaTask threadPollKafkaTask = applicationContext.getBean(ThreadPollKafkaTask.class);

            List<String> topics = new ArrayList<>();
            topics.add("test1");
            threadPollKafkaTask.setTopics(topics);
            threadPollKafkaTask.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
