package com.kaiasia.bai5.beans;

import org.springframework.stereotype.Component;

@Component("tShirt")
public class TShirt implements Outfit{
    @Override
    public void name() {
        System.out.println("Tshirt");
    }
}
