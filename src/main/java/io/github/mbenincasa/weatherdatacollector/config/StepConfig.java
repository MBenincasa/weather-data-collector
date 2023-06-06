package io.github.mbenincasa.weatherdatacollector.config;

import io.github.mbenincasa.weatherdatacollector.domain.City;
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
    private final JpaCursorItemReader<City> jpaCursorItemReader;

    @Bean
    public Step step() {
        return new StepBuilder("step", jobRepository)
                .<City, String>chunk(2, transactionManager)
                .reader(jpaCursorItemReader)
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemProcessor<City, String> processor() {
        return new StepProcessor();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new StepWriter();
    }
}
