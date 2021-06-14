package com.nanhai.zuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@EnableZuulProxy
@SpringBootApplication
public class NanhaiZuulGatewayApplication {
    /*@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        //KB,MB
        factory.setMaxFileSize(DataSize.ofBytes(5000000));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofBytes(10000000));
        return factory.createMultipartConfig();
    }*/


    public static void main(String[] args) {
        SpringApplication.run(NanhaiZuulGatewayApplication.class, args);
    }
}
