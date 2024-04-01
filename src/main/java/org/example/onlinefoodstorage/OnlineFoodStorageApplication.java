package org.example.onlinefoodstorage;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.example.onlinefoodstorage.properties.OpenAPIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(OpenAPIProperties.class)
@EnableCaching
public class OnlineFoodStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineFoodStorageApplication.class, args);
    }

}
