package org.example.onlinefoodstorage.config.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisConfig {
    @Value("${cache.config.entryTtl}")
    private int entryTtl;

    @Value("${cache.config.other.entryTtl}")
    private int countryNamesEntryTtl;

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(entryTtl))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> builder
                .withCacheConfiguration(CacheNames.OTHER_ENTRY,
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(countryNamesEntryTtl)));
//                .withCacheConfiguration("otherNAme",
//                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(countryNamesEntryTtl)));
    }
}
