package com.cydeo.client;

import com.cydeo.dto.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="http://api.weatherstack.com", name="WEATHER-CLIENT")
public interface WeatherApiClient {

    @GetMapping("/current")
    WeatherDTO getCurrentWeather(@RequestParam("access_key") String key,
                                 @RequestParam(value="query") String city
                                 );

}
