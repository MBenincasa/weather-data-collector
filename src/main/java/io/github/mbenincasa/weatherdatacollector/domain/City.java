package io.github.mbenincasa.weatherdatacollector.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
@Table(name = "t_city")
public class City {

    @Id
    private Long id;
    private String name;
    private Double lat;
    private Double lon;
    private String country;
    private String state;
}
