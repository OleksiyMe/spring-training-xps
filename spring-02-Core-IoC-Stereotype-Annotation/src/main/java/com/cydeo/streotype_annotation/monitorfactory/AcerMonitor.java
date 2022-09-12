package com.cydeo.streotype_annotation.monitorfactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class AcerMonitor extends Monitor{


    public AcerMonitor() {
        super("Good Acer","Acer",26);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");
    }
}
