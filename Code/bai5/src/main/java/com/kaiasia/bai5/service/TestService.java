package com.kaiasia.bai5.service;

import com.kaiasia.bai5.beans.Outfit;
import com.kaiasia.bai5.beans.SingletonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class TestService {

    @Value("#{'${kaiasia.demo}'.split(',')}")
    private List<String> demoStr;

//    @Qualifier("tShirt")
//    @Autowired
//    private Outfit outfit;

    @Autowired
    private SingletonBean singletonBeanA;

    @Autowired
    private SingletonBean singletonBeanB;

//    @Autowired
//    public void setSingletonBeanA(SingletonBean a){
//        this.singletonBeanA = a;
//    }
//
//    @Autowired
//    public void setSingletonBeanB(SingletonBean b){
//        this.singletonBeanB = b;
//    }

//    public TestService(SingletonBean a, SingletonBean b){
//        this.singletonBeanA = a;
//        this.singletonBeanB = b;
//    }

    @EventListener(ApplicationReadyEvent.class)
    public void doTest(){
        System.out.println(demoStr);
    }

    @PostConstruct
    public void init(){
        System.out.println("TestService PostContructor");
    }

    @PreDestroy
    public void checkSingletonBean(){
        System.out.println("Predestroy");  //expect result = true
    }

}
