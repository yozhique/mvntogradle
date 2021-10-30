package com.countryapi.countryapi;

import com.countryapi.countryapi.services.CountryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerIntTest {

    @Autowired
    private CountryService countryService;

    @Autowired
    private MockMvc mvc;

    @Test
    void getCountriesTop10ByPopulation() throws Exception {
        mvc.perform(get("/countries/populationTopTen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCountriesTop10ByArea() throws Exception {
        mvc.perform(get("/countries/areaTopTen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCountriesTop10ByDensity() throws Exception {
        mvc.perform(get("/countries/densityTopTen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
