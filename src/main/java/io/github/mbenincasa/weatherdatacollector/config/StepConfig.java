package io.github.mbenincasa.weatherdatacollector.config;

import io.github.mbenincasa.weatherdatacollector.client.OpenWeatherClient;
import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import io.github.mbenincasa.weatherdatacollector.dto.response.CurrentWeatherResponse;
import io.github.mbenincasa.weatherdatacollector.step.StepProcessor;
import io.github.mbenincasa.weatherdatacollector.step.StepWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;
    private final JpaCursorItemReader<CityDTO> jpaCursorItemReader;
    private final OpenWeatherClient openWeatherClient;

    @Bean
    public Step step() {
        return new StepBuilder("step", jobRepository)
                .<CityDTO, CurrentWeatherResponse>chunk(2, transactionManager)
                .reader(jpaCursorItemReader)
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemProcessor<CityDTO, CurrentWeatherResponse> processor() {
        return new StepProcessor(openWeatherClient);
    }

    @Bean
    public ItemWriter<CurrentWeatherResponse> writer() {
        return new StepWriter();
    }
}
