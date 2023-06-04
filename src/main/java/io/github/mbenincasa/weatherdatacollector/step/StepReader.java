package io.github.mbenincasa.weatherdatacollector.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;

import java.util.Arrays;
import java.util.Iterator;

@Slf4j
public class StepReader implements ItemReader<String> {

    private final Iterator<String> iterator = Arrays.asList("Alfa", "Bravo", "Charlie", "Delta").iterator();

    @Override
    public String read() {
        var item = iterator.hasNext()
                ? iterator.next()
                : null;

        log.info("[READER] - {}", item);
        return item;
    }
}
