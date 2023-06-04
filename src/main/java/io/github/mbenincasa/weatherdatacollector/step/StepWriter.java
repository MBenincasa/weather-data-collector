package io.github.mbenincasa.weatherdatacollector.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class StepWriter implements ItemWriter<String> {

    @Override
    public void write(Chunk<? extends String> chunk) {
        for (String item : chunk)
            log.info("[WRITER] - {}", item);
    }
}
