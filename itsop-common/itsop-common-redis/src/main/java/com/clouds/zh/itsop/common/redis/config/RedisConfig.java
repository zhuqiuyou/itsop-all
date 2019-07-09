package com.clouds.zh.itsop.common.redis.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.clouds.zh.itsop.common.redis.serializer.FastJson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import sun.net.www.content.text.Generic;

import java.text.SimpleDateFormat;


@Configuration
public class RedisConfig {


 
    /**
     * 重写Redis序列化方式，使用kryo自定义序列化方式:
     * 当我们的数据存储到Redis的时候，我们的键（key）和值（value）都是通过Spring提供的Serializer序列化到数据库的。RedisTemplate默认使用的是JdkSerializationRedisSerializer，StringRedisTemplate默认使用的是StringRedisSerializer。
     * Spring Data JPA为我们提供了下面的Serializer：
     * GenericToStringSerializer、GenericJackson2JsonRedisSerializer 、Jackson2JsonRedisSerializer、JacksonJsonRedisSerializer、JdkSerializationRedisSerializer、OxmSerializer、StringRedisSerializer。
     * 在此我们将自己配置RedisTemplate并定义Serializer。
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //Kryo自定义序列化
        //KryoRedisSerializer kryoRedisSerializer= new KryoRedisSerializer(Object.class);

        //使用fastjson序列化
        FastJson2JsonRedisSerializer json2JsonRedisSerializer=new FastJson2JsonRedisSerializer(Object.class);
        ParserConfig.getGlobalInstance().addAccept("com.clouds.zh.itsop.common.module.");



        // 使用Jackson2JsonRedisSerialize 替换默认序列化
/*        Jackson2JsonRedisSerializer json2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        json2JsonRedisSerializer.setObjectMapper(objectMapper);*/

        //使用 GenericJackson2JsonRedisSerializer 替换默认序列化
        //GenericJackson2JsonRedisSerializer json2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();

        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        // 设置键 value 的序列化采用StringRedisSerializer。
        redisTemplate.setHashValueSerializer(json2JsonRedisSerializer);
        redisTemplate.setValueSerializer(json2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
 
}