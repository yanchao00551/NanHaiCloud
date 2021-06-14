package com.nanhai.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NanhaiEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NanhaiEurekaServerApplication.class, args);
    }

}
