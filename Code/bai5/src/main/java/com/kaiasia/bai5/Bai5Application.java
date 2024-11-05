package com.kaiasia.bai5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
//@ImportResource({"classpath:spring-beans.xml"})
public class Bai5Application {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext
//        AnnotationConfigApplicationContext
//        WebApplicationContext
        SpringApplication.run(Bai5Application.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void doTest(){
        List<String> listBeans = Arrays.asList(applicationContext.getBeanDefinitionNames());
        for(String name : listBeans){
            System.out.println(name);
        }
    }

}
