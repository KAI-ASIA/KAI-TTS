//package sb.locnv.w6.redis;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@Configuration
//public class RedisConfiguration {
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//        return new LettuceConnectionFactory("14.225.254.212", 6379);
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(){
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        return new RedisTemplate<>();
//    }
//
//}
