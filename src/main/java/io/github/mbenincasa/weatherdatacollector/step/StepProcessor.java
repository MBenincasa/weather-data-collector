package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.client.OpenWeatherClient;
import io.github.mbenincasa.weatherdatacollector.domain.City;
import io.github.mbenincasa.weatherdatacollector.domain.WeatherData;
import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import io.github.mbenincasa.weatherdatacollector.dto.response.CurrentWeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class StepProcessor implements ItemProcessor<CityDTO, WeatherData> {

    private final OpenWeatherClient openWeatherClient;

    @Override
    public WeatherData process(CityDTO cityDto) {
        log.debug("[PROCESSOR INPUT] - {}", cityDto);
        var data = openWeatherClient.getCurrentWeather(cityDto);
        log.debug("[PROCESSOR OUTPUT] - {}", data);
        return mapData(cityDto, data);
    }

    private WeatherData mapData(CityDTO cityDto, CurrentWeatherResponse data) {
        Instant instant = Instant.ofEpochSecond(data.getDt());
        LocalDateTime date = LocalDateTime.ofInstant(instant, ZoneOffset.ofTotalSeconds(data.getTimezone()));
        return WeatherData.builder()
                .date(date)
                .weather(data.getWeathers()
                        .stream()
                        .map(CurrentWeatherResponse.Weather::getDescription)
                        .collect(Collectors.joining(", ")))
                .temp(data.getMain().getTemp())
                .humidity(data.getMain().getHumidity())
                .pressure(data.getMain().getPressure())
                .wind(data.getWind().getSpeed() + " m/s " + data.getWind().getDeg() + "°")
                .rain(data.getRain() == null
                        ? null
                        : data.getRain().getOneHour())
                .snow(data.getSnow() == null
                        ? null
                        : data.getSnow().getOneHour())
                .city(toCity(cityDto))
                .build();
    }

    private City toCity(CityDTO cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .lat(cityDto.getLat())
                .lon(cityDto.getLon())
                .state(cityDto.getState())
                .name(cityDto.getName())
                .country(cityDto.getCountry())
                .build();
    }
}
