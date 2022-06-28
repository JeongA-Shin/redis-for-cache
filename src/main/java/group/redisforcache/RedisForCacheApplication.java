package group.redisforcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching // 해당 어노테이션을 선언하면 스프링 부트에서는 @Cacheable과 같은 캐싱 어노테이션의 사용을 인식
@EnableJpaAuditing
public class RedisForCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisForCacheApplication.class, args);
    }

}
