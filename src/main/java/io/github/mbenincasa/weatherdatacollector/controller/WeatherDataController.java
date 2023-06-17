package io.github.mbenincasa.weatherdatacollector.controller;

import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataDTO;
import io.github.mbenincasa.weatherdatacollector.service.WeatherDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> getReportWeatherDataFiltered(Pageable pageable, @RequestParam String city) {
        var report = weatherDataService.getReportWeatherDataFiltered(pageable, city);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=report.xlsx")
                .body(report);
    }
}
