package io.github.mbenincasa.weatherdatacollector.config;

import io.github.mbenincasa.weatherdatacollector.client.OpenWeatherClient;
import io.github.mbenincasa.weatherdatacollector.domain.WeatherData;
import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import io.github.mbenincasa.weatherdatacollector.step.StepProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;
    private final JpaCursorItemReader<CityDTO> jpaCursorItemReader;
    private final JpaItemWriter<WeatherData> jpaItemWriter;
    private final OpenWeatherClient openWeatherClient;

    @Bean
    public Step step() {
        return new StepBuilder("step", jobRepository)
                .<CityDTO, WeatherData>chunk(2, transactionManager)
                .reader(jpaCursorItemReader)
                .processor(processor())
                .writer(jpaItemWriter)
                .build();
    }

    @Bean
    public ItemProcessor<CityDTO, WeatherData> processor() {
        return new StepProcessor(openWeatherClient);
    }

//    @Bean
//    public ItemWriter<WeatherDataRecord> writer() {
//        return new StepWriter();
//    }
}
