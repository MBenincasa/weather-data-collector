package io.github.mbenincasa.weatherdatacollector.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CurrentWeatherResponse {

    private String base;
    private Coord coord;
    @JsonProperty("weather")
    private List<Weather> weathers;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    private Integer dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer code;

    @Data
    @ToString
    public static class Coord {
        private Double lat;
        private Double lon;
    }

    @Data
    @ToString
    public static class Weather {
        private Integer id;
        private String main;
        private String description;
        private String icon;
    }

    @Data
    @ToString
    public static class Main {
        private Double temp;
        @JsonProperty("feels_like")
        private Double feelsLike;
        @JsonProperty("temp_min")
        private Double tempMin;
        @JsonProperty("temp_max")
        private Double tempMax;
        private Integer pressure;
        private Integer humidity;
        @JsonProperty("sea_level")
        private Integer seaLevel;
        @JsonProperty("grnd_level")
        private Integer grndLevel;
    }

    @Data
    @ToString
    public static class Wind {
        private Double speed;
        private Integer deg;
        private Double gust;
    }

    @Data
    @ToString
    public static class Clouds {
        private Integer all;
    }

    @Data
    @ToString
    public static class Rain {
        @JsonProperty("1h")
        private Double oneHour;
        @JsonProperty("3h")
        private Double threeHour;
    }

    @Data
    @ToString
    public static class Snow {
        @JsonProperty("1h")
        private Double oneHour;
        @JsonProperty("3h")
        private Double threeHour;
    }

    @Data
    @ToString
    private static class Sys {
        private Integer type;
        private Integer id;
        private String country;
        private Integer sunrise;
        private Integer sunset;
    }
}
