package com.kaiasia.bai5.beans;

import org.springframework.stereotype.Component;

@Component("shirt")
public class Shirt implements Outfit{
    @Override
    public void name() {
        System.out.println("Shirt");
    }
}
