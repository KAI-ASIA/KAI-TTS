package sb.locnv.week9learn.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.RedisCustomConversions;

import java.util.Arrays;

@Configuration
public class RedisConfiguration {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port2Write}")
    private int port2Write;

    @Value("${redis.port2Read}")
    private int port2Read;

    @Value("${redis.numDB}")
    private int numDB;


    @Bean
    @Primary
    public LettuceConnectionFactory lettuceConnectionFactoryDB(){
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(redisHost);
        standaloneConfiguration.setPort(port2Write);
        standaloneConfiguration.setDatabase(numDB);
        return  new LettuceConnectionFactory(standaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactoryDB());
        return redisTemplate;
    }

    @Bean
    public RedisCustomConversions redisCustomConversions(CustomerConvertRedis.TimestampToByte var1, CustomerConvertRedis.ByteToTimeStamp var2){
        return new RedisCustomConversions(Arrays.asList(var1, var2));
    }

    @Bean
    @Qualifier("connectionFactory2Read")
    public LettuceConnectionFactory lettuceConnectionFactory2Read(){
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(redisHost);
        standaloneConfiguration.setPort(port2Read);
        return  new LettuceConnectionFactory(standaloneConfiguration);
    }

    @Bean
    @Qualifier("connectionFactory2Write")
    public LettuceConnectionFactory lettuceConnectionFactory2Write(){
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(redisHost);
        standaloneConfiguration.setPort(port2Write);
        return  new LettuceConnectionFactory(standaloneConfiguration);
    }

    @Bean
    @Qualifier("redisTemplate2Read")
    public RedisTemplate<String, Object> redisTemplate2Read(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory2Read());
        return redisTemplate;
    }

    @Bean
    @Qualifier("redisTemplate2Write")
    public RedisTemplate<String, Object> redisTemplate2Write(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory2Write());
        return redisTemplate;
    }

}
