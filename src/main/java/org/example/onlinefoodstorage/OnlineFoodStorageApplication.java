package org.example.onlinefoodstorage;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.example.onlinefoodstorage.properties.OpenAPIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties(OpenAPIProperties.class)
public class OnlineFoodStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineFoodStorageApplication.class, args);
    }

}
