package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony(){
        return new SonyMonitor(  "25 inc Beast", "Sony", 25);
    }

    @Bean
    public Motherboard asusmotherboard(){
        return new AsusMotherboard("K50","Asus",4,3,"123bios");
    }

    @Bean
    public Case caseDell(){
        return new DellCase("k34","Dell","Good PSU");
    }


}
