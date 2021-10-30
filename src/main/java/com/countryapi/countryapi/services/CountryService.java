package com.countryapi.countryapi.services;

import com.countryapi.countryapi.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CountryService {

    CountryRestService countryRestService;

    public CountryService(CountryRestService countryRestService) {
        this.countryRestService = countryRestService;
    }

    public List<Country> getCountriesTopTenByPopulation() {
        return countryRestService.getCountries().stream()
                .filter(country -> country.getPopulation() != null)
                .sorted(Comparator.comparing(Country::getPopulation).reversed())
                .limit(10)
                .collect(toList());
    }

    public List<Country> getCountriesTopTenByArea() {
        return countryRestService.getCountries().stream()
                .filter(country -> country.getArea() != null)
                .sorted(Comparator.comparing(Country::getArea).reversed())
                .limit(10)
                .collect(toList());
    }

    public List<Country> getCountriesTopTenByDensity() {
        return countryRestService.getCountries().stream()
                .filter(country -> country.getArea() != null && country.getPopulation() != null)
                .sorted(Comparator.comparing((Country c) -> c.getPopulation() / c.getArea()).reversed())
                .limit(10)
                .collect(toList());
    }

}