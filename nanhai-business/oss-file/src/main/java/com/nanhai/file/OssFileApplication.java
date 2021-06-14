package com.nanhai.file;

import com.nanhai.core.framework.object.MyRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;



@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.nanhai.file.mapper")
public class OssFileApplication {

    /**
     * 让restTemplate具备Ribbon负载均衡的能力。
     * 由于使用feign, 弃用该方式
     */
    @Bean(name="myRestTemplate")
    @LoadBalanced
    MyRestTemplate restTemplate() {
        return new MyRestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OssFileApplication.class, args);
    }

}
