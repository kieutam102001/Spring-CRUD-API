package com.example.hellospringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bikini")
public class Bikini implements Outfit{

    @Override
    public void wear() {
        System.out.println("Dang mac bikini");
    }
}
