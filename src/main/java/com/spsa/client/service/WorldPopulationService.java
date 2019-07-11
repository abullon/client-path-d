package com.spsa.client.service;

import com.spsa.client.model.Client;
import com.spsa.client.model.TotalLifeExpectancy;
import com.spsa.client.util.DateUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WorldPopulationService {

    RestTemplate restTemplate = new RestTemplate();

    public Double getTotalLifeExpectancy(Client client) {
        String url = "http://54.72.28.201:80/1.0/life-expectancy/total/"+client.getGender()+"/"+client.getCountry()+"/"+ DateUtils.format(client.getBirthday(),DateUtils.SMALL_DATE_FORMAT)+"/";
        TotalLifeExpectancy response = restTemplate.getForObject(
                url,
                TotalLifeExpectancy.class);
    return response.getTotalLifeExpectancy();
    }
}
