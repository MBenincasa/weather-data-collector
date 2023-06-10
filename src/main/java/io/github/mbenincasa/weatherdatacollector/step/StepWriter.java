package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.dto.response.CurrentWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class StepWriter implements ItemWriter<CurrentWeatherResponse> {

    @Override
    public void write(Chunk<? extends CurrentWeatherResponse> chunk) {
        for (CurrentWeatherResponse item : chunk)
            log.debug("[WRITER] - {}", item);
    }
}
