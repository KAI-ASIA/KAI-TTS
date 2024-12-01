package sb.locnv.week9learn.service.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkProducerSend {

    @Autowired
    private Producer<String, String> producers;

    public void sendMessage(String topic, String key, String message) throws Exception{
        ProducerRecord<String, String> record = null;
        try{
            record = new ProducerRecord<>(topic, key, message);
            producers.send(record);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
