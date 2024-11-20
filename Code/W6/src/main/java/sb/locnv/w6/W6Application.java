package sb.locnv.w6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class W6Application {

    public static void main(String[] args) {
//        DataSourceAutoConfiguration
//        RedisAutoConfiguration
        SpringApplication.run(W6Application.class, args);
    }

}
