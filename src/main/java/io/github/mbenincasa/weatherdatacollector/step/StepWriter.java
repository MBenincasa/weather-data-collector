package io.github.mbenincasa.weatherdatacollector.step;

import io.github.mbenincasa.weatherdatacollector.domain.WeatherData;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StepWriter {

    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public JpaItemWriter<WeatherData> jpaItemWriter() {
        JpaItemWriter<WeatherData> writer = new JpaItemWriter<>() {
            @Override
            public void write(Chunk<? extends WeatherData> items) {
                log.debug("[WRITER] - {}", items);
                super.write(items);
            }
        };
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }
}
