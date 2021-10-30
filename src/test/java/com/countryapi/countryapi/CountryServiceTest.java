package com.countryapi.countryapi;

import com.countryapi.countryapi.models.Country;
import com.countryapi.countryapi.services.CountryRestService;
import com.countryapi.countryapi.services.CountryService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CountryServiceTest {

    @InjectMocks
    private CountryService service;

    @Mock
    private CountryRestService countryRestService;

    @BeforeEach
    public void init() {
        when(countryRestService.getCountries()).thenReturn(getMockCountriesList());
    }

    private List<Country> getMockCountriesList() {
        List<Country> result = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            result.add(getMockCountry(i));
        }
        return result;
    }

    private Country getMockCountry(int i) {
        Country country = new Country();
        country.setName("Country" + i);
        country.setArea(i * i * 1000);
        country.setPopulation(i * 20_000);
        country.setCapital("Capital" + i);
        return country;
    }

    @Test
    public void getCountriesTopTenByPopulationTest() {
        List<Country> result = service.getCountriesTopTenByPopulation();
        assertThat(result.size()).isEqualTo(10);
        int index = 0;
        for (int i = 20; i >= 11; i--) {
            assertThat(result.get(index).getName()).isEqualTo("Country" + i);
            index++;
        }
    }

    @Test
    public void getCountriesTopTenByAreaTest() {
        List<Country> result = service.getCountriesTopTenByArea();
        assertThat(result.size()).isEqualTo(10);
        int index = 0;
        for (int i = 20; i >= 11; i--) {
            assertThat(result.get(index).getName()).isEqualTo("Country" + i);
            index++;
        }
    }

    @Test
    public void getCountriesTopTenByDensityTest() {
        List<Country> result = service.getCountriesTopTenByDensity();
        assertThat(result.size()).isEqualTo(10);
        int index = 0;
        for (int i = 1; i <= 10; i++) {
            assertThat(result.get(index).getName()).isEqualTo("Country" + i);
            index++;
        }
    }
}
