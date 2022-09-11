package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.config.AdditionalConfig;
import com.cydeo.bean_annotation.config.ComputerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container=
                new  AnnotationConfigApplicationContext(ComputerConfig.class,
                        AdditionalConfig.class);








    }
}
