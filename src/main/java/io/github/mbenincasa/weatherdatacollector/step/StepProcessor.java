package io.github.mbenincasa.weatherdatacollector.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class StepProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) {
        log.info("[PROCESSOR] - {}", item);
        return item;
    }
}
