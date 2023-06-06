package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.domain.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class StepProcessor implements ItemProcessor<City, String> {

    @Override
    public String process(City item) {
        log.info("[PROCESSOR] - {}", item.getName());
        return item.getName();
    }
}
