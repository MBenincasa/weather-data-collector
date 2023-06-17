package io.github.mbenincasa.weatherdatacollector.mapper;

import io.github.mbenincasa.weatherdatacollector.domain.City;
import io.github.mbenincasa.weatherdatacollector.domain.WeatherData;
import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataDTO;
import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataReportDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public WeatherDataDTO toWeatherDataDTO(WeatherData wd) {
        return WeatherDataDTO.builder()
                .id(wd.getId())
                .date(wd.getDate())
                .weather(wd.getWeather())
                .temp(wd.getTemp())
                .humidity(wd.getHumidity())
                .pressure(wd.getPressure())
                .wind(wd.getWind())
                .rain(wd.getRain())
                .snow(wd.getSnow())
                .city(toCityDTO(wd.getCity()))
                .build();
    }

    public WeatherDataReportDTO toWeatherDataReportDTO(WeatherData wd) {
        return WeatherDataReportDTO.builder()
                .id(wd.getId())
                .date(wd.getDate())
                .weather(wd.getWeather())
                .temp(wd.getTemp())
                .humidity(wd.getHumidity())
                .pressure(wd.getPressure())
                .wind(wd.getWind())
                .rain(wd.getRain())
                .snow(wd.getSnow())
                .city(toCityDTO(wd.getCity()).getName())
                .build();
    }

    public City toCity(CityDTO cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .lat(cityDto.getLat())
                .lon(cityDto.getLon())
                .state(cityDto.getState())
                .name(cityDto.getName())
                .country(cityDto.getCountry())
                .build();
    }

    public CityDTO toCityDTO(City city) {
        return CityDTO.builder()
                .id(city.getId())
                .lat(city.getLat())
                .lon(city.getLon())
                .state(city.getState())
                .name(city.getName())
                .country(city.getCountry())
                .build();
    }
}
