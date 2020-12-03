package com.example.spring;

import com.example.spring.config.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
@EnableCaching
@ComponentScan(basePackages = {"com.example.spring.dao"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //SpringApplication app = new SpringApplication(Application.class);
        //app.setBannerMode(Banner.Mode.OFF);

    }


}
