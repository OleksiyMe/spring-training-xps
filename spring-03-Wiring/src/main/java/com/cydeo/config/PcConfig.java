package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class PcConfig {

    @Bean
    public Dimensions dimentions(){

        return new Dimensions(10,20,30);
    }


    @Bean
    public Case caseDell(Dimensions dimensions){
        return new DellCase("Dell", "Dell", "220", dimensions);
    }

}
