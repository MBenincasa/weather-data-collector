package io.github.mbenincasa.weatherdatacollector.config;

import io.github.mbenincasa.weatherdatacollector.step.StepProcessor;
import io.github.mbenincasa.weatherdatacollector.step.StepReader;
import io.github.mbenincasa.weatherdatacollector.step.StepWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class StepConfig {

    private final PlatformTransactionManager transactionManager;
    private final JobRepository jobRepository;

    @Bean
    public Step step() {
        return new StepBuilder("step", jobRepository)
                .<String, String>chunk(2, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemReader<String> reader() {
        return new StepReader();
    }

    @Bean
    public ItemProcessor<String, String> processor() {
        return new StepProcessor();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new StepWriter();
    }
}
