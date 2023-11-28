package io.github.dudupuci.mscartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscartoesApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "test");
        SpringApplication.run(MscartoesApplication.class, args);
    }

}
