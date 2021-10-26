package com.countryapi.countryapi.services;

import com.countryapi.countryapi.models.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CountryService {

    @Value("${restcountries.url}")
    private String restcountriesUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Country> getCountriesTopTenByPopulation() {
        return getCountries().stream()
                .filter(country -> country.getPopulation() != null)
                .sorted(Comparator.comparing(Country::getPopulation).reversed())
                .limit(10)
                .collect(toList());
    }

    public List<Country> getCountriesTopTenByArea() {
        return getCountries().stream()
                .filter(country -> country.getArea() != null)
                .sorted(Comparator.comparing(Country::getArea).reversed())
                .limit(10)
                .collect(toList());
    }

    public List<Country> getCountriesTopTenByDensity() {
        return getCountries().stream()
                .filter(country -> country.getArea() != null && country.getPopulation() != null)
                .sorted(Comparator.comparing((Country c) -> c.getPopulation() / c.getArea()).reversed())
                .limit(10)
                .collect(toList());
    }

    public List<Country> getCountries() {
        var countries = restTemplate.getForObject(restcountriesUrl, Country[].class);
        return Arrays.asList(countries);
    }
}