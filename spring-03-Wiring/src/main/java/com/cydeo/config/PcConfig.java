package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimentions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

public class PcConfig {

    @Bean
    public Dimentions dimentions(){

        return new Dimentions(10,20,30);
    }


    @Bean
    public Case caseDell(Dimentions dimentions){
        return new DellCase("Dell", "Dell", "220", dimentions);
    }

}
