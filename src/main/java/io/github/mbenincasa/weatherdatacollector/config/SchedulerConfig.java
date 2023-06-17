package io.github.mbenincasa.weatherdatacollector.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class SchedulerConfig {

    private final Job job;
    private final JobLauncher jobLauncher;

    @Scheduled(cron = "${scheduler.cron-job}")
    public void runJob() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        try {
            log.debug("Job in execution: {}", job.getName());
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            log.debug("Job completed with state: {}", jobExecution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
