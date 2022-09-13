package com.cydeo.streotype_annotation.config;


import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.casefactory.DellCase;
import com.cydeo.streotype_annotation.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.cydeo.streotype_annotation")
public class PcConfig {

    @Bean
    public Dimensions dimensions(){

        return new Dimensions(10,20,30);
    }


    @Bean
    public Case caseDell(Dimensions dimensions){
        return new DellCase("Dell", "Dell", "220", dimensions);
    }

}
