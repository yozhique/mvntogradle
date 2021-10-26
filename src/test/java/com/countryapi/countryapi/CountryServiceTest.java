package com.countryapi.countryapi;

import com.countryapi.countryapi.models.Country;
import com.countryapi.countryapi.services.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService service;

    @Test
    public void getCountriesTopTenByPopulationTest() {
        List<Country> result = service.getCountriesTopTenByPopulation();
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0).getPopulation()).isGreaterThan(result.get(1).getPopulation());
    }

    @Test
    public void getCountriesTopTenByAreaTest() {
        List<Country> result = service.getCountriesTopTenByArea();
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0).getArea()).isGreaterThan(result.get(1).getArea());
    }

    @Test
    public void getCountriesTopTenByDensityTest() {
        List<Country> result = service.getCountriesTopTenByDensity();
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.get(0).getPopulation() / result.get(0).getArea())
                .isGreaterThan(result.get(1).getArea() / result.get(1).getArea());
    }

    @Test
    public void getCountriesFullListTest() {
        List<Country> result = service.getCountries();
        assertThat(result.size()).isGreaterThanOrEqualTo(27);
    }
}
