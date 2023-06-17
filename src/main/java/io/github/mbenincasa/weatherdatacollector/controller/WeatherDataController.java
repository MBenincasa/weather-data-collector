package io.github.mbenincasa.weatherdatacollector.controller;

import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataDTO;
import io.github.mbenincasa.weatherdatacollector.service.WeatherDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather-data/")
@Slf4j
public class WeatherDataController {

    private final WeatherDataService weatherDataService;

    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public Page<WeatherDataDTO> getWeatherDataFiltered(Pageable pageable, @RequestParam String city) {
        return weatherDataService.getWeatherDataFiltered(pageable, city);
    }
}
