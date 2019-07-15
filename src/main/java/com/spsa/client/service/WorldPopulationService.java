package com.spsa.client.service;

import com.spsa.client.model.Client;
import com.spsa.client.model.Countries;
import com.spsa.client.model.LifeExpectancy;
import com.spsa.client.util.DateUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration
@RestController
public class WorldPopulationService {

    RestTemplate restTemplate = new RestTemplate();

    public Double getTotalLifeExpectancy(Client client) {
        String url = "http://54.72.28.201:80/1.0/life-expectancy/total/" + client.getGender() + "/" + client.getCountry() + "/" + DateUtils.format(client.getBirthday(), DateUtils.SMALL_DATE_FORMAT) + "/";
        LifeExpectancy response = restTemplate.getForObject(
                url,
                LifeExpectancy.class);
        return response.getTotalLifeExpectancy();
    }

    @CrossOrigin(origins = "https://path-d-frontend.firebaseapp.com")
    @GetMapping("/countries")
    public Countries getCountry() {
        return  restTemplate.getForObject(
                "http://54.72.28.201/1.0/countries",
                Countries.class);
    }
}