package group.redisforcache.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@EnableCaching // 해당 어노테이션을 선언하면 스프링 부트에서는 @Cacheable과 같은 캐싱 어노테이션의 사용을 인식
public class RedisConfig {

  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private int port;

  @Bean
  public RedisConnectionFactory redisConnectionFactory(){
    return new LettuceConnectionFactory(host,port);
  }

}
