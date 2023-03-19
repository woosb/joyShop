package com.joyshop.joy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JoyShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoyShopApplication.class, args);
    }

}
