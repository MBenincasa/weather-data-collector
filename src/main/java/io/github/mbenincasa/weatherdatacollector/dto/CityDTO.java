package io.github.mbenincasa.weatherdatacollector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CityDTO {

    private Long id;
    private String name;
    private Double lat;
    private Double lon;
    private String country;
    private String state;
}
