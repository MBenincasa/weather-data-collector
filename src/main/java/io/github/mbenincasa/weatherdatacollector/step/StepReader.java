package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.domain.City;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StepReader {

    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaCursorItemReader<City> jpaCursorItemReader() {
        JpaCursorItemReader<City> reader = new JpaCursorItemReader<>() {
            @Override
            protected City doRead() {
                City city = super.doRead();
                if (city != null)
                    log.info("[READER] - {}", city.getName());
                return city;
            }
        };

        reader.setName("jpaCursorItemReader");
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT c FROM City c");

        return reader;
    }
}
