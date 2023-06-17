package io.github.mbenincasa.weatherdatacollector.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@ToString
public class WeatherDataDTO {

    private Long id;
    private LocalDateTime date;
    private String weather;
    private Double temp; // °C
    private Integer humidity; // %
    private Integer pressure; // hPa
    private String wind;
    private Double rain; // mm
    private Double snow; // mm
    private CityDTO city;
}
