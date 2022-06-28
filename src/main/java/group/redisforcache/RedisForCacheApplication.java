package group.redisforcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RedisForCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisForCacheApplication.class, args);
    }

}
