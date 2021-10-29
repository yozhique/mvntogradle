package com.countryapi.countryapi.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Country {
    private CountryName name;
    private List<String> capital;
    private Map<String, CountryCurrency> currencies;
    private Integer population;
    private Integer area;
}
