package sb.locnv.week9learn.task;

import lombok.Data;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

@Component
@Data
public class ThreadPollKafkaTask extends Thread{

    @Autowired
    private Consumer<String, String> consumer;

    private List<String> topics;

    @Override
    public void run() {
        System.out.println("Start poll");
        consumer.subscribe(topics);
        while (true){
            try{
                Thread.sleep(500);
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(1000));
                if(consumerRecords == null || consumerRecords.count() == 0){
                    continue;
                }
                System.out.println(consumerRecords.count());
                Iterator iterator = consumerRecords.iterator();

                while (iterator.hasNext()){
                    ConsumerRecord<String, String> record = (ConsumerRecord<String, String>) iterator.next();
                    try{
                        String message = record.value();
                        //Todo task here
                        System.out.println(message);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
                consumer.commitAsync();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //Todo here
            }
        }
    }
}
