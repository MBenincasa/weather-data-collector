package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.client.OpenWeatherClient;
import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import io.github.mbenincasa.weatherdatacollector.dto.response.CurrentWeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
@RequiredArgsConstructor
public class StepProcessor implements ItemProcessor<CityDTO, CurrentWeatherResponse> {

    private final OpenWeatherClient openWeatherClient;

    @Override
    public CurrentWeatherResponse process(CityDTO cityDto) {
        log.debug("[PROCESSOR INPUT] - {}", cityDto);
        var response = openWeatherClient.getCurrentWeather(cityDto);
        log.debug("[PROCESSOR OUTPUT] - {}", response);
        return response;
    }
}
