package sb.locnv.week9learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories(basePackages = "sb.locnv.week9learn.redisrepository")
@EnableJpaRepositories(basePackages = "sb.locnv.week9learn.repository")
public class Week9LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week9LearnApplication.class, args);
    }

}
