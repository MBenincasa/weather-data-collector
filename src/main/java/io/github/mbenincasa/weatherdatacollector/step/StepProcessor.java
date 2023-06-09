package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.client.OpenWeatherClient;
import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
@RequiredArgsConstructor
public class StepProcessor implements ItemProcessor<CityDTO, String> {

    private final OpenWeatherClient openWeatherClient;

    @Override
    public String process(CityDTO cityDto) {
        log.info("[PROCESSOR] - {}", cityDto);
        var response = openWeatherClient.getCurrentWeather(cityDto);
        log.info("[PROCESSOR RESPONSE] - {}", response);
        return cityDto.getName();
    }
}
