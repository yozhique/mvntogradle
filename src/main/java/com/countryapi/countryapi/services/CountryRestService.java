package com.countryapi.countryapi.services;

import com.countryapi.countryapi.models.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryRestService {

    @Value("${restcountries.url}")
    private String restcountriesUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Country> getCountries() {
        var countries = restTemplate.getForObject(restcountriesUrl, Country[].class);
        return Arrays.asList(countries);
    }
}
