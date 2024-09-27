package ru.perminov.aggrewater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class aggreWater {
        public static void main(String[] args) {
            SpringApplication.run(aggreWater.class, args);
    }
}
