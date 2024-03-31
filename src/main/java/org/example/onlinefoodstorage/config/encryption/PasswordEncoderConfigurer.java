package org.example.onlinefoodstorage.config.encryption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderConfigurer {
    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(10);
//    }
    public String encoder() {
        return null;
    }


}
