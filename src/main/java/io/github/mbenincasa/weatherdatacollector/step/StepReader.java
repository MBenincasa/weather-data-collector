package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
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
    public JpaCursorItemReader<CityDTO> jpaCursorItemReader() {
        JpaCursorItemReader<CityDTO> reader = new JpaCursorItemReader<>() {
            @Override
            protected CityDTO doRead() {
                var cityDto = super.doRead();
                if (cityDto != null)
                    log.info("[READER] - {}", cityDto);
                return cityDto;
            }
        };

        reader.setName("jpaCursorItemReader");
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT new io.github.mbenincasa.weatherdatacollector.dto.CityDTO(c.id, c.name, c.lat, c.lon, c.country, c.state) FROM City c");

        return reader;
    }
}
