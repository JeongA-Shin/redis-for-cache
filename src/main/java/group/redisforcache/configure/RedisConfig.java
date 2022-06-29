package group.redisforcache.configure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//Redis와의 연결을 위한 설정

@Configuration
public class RedisConfig {

  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private int port;

//  @Bean
//  public ObjectMapper objectMapper(){
//    ObjectMapper mapper = new ObjectMapper();
//    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//    mapper.registerModule(new JodaModule());
//    return mapper;
//  }


  //Spring Boot 에서 Redis 를 사용하는 방법에는 RedisRepository 와 RedisTemplate 두 가지가 있다

  //0. Redis 사용을 위한 기본 Configuration (공통 세팅)
  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName(host);
    redisStandaloneConfiguration.setPort(port);
    LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
    return connectionFactory;
  }

  //1. RedisRepository를 사용하려면 여기서는 더 딱히 할 게 없음

  //2. RedisTemplate 사용을 위한 빈 설정 - redis에 대한 접근 방식
  @Bean
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<Object, Object> template = new RedisTemplate<>();
//    template.setDefaultSerializer(RedisSerializer.json());
    template.setKeySerializer(new StringRedisSerializer());//template.setKeySerializer(RedisSerializer.string());
    template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

    //TO-D0: https://www.geeksforgeeks.org/spring-boot-customize-the-jackson-objectmapper/
    //JODA TIME 관련해서 Serialize 하는 것 찾아서 추가
    template.setConnectionFactory(redisConnectionFactory);
    //template.setKeySerializer(new StringRedisSerializer());
    return template;
  }

}
