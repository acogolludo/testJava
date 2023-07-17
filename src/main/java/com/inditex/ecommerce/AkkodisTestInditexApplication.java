package com.inditex.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication(scanBasePackages={"com.inditex.ecommerce"})
//@EnableJpaRepositories(basePackages = "com.inditex.ecommerce.repository")
//@EntityScan(basePackages = "com.inditex.ecommerce.entities")
//@ComponentScan(basePackages = "com.inditex.ecommerce")
public class AkkodisTestInditexApplication {

    public static void main(String[] args){
	    SpringApplication.run(AkkodisTestInditexApplication .class,args);
}

}
