package io.github.mbenincasa.weatherdatacollector.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_weather_data")
public class WeatherData {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;
    private String weather;
    private Double temp; // °C
    private Integer humidity; // %
    private Integer pressure; // hPa
    private String wind;
    private Double rain; // mm
    private Double snow; // mm
    @ManyToOne
    private City city;
}
