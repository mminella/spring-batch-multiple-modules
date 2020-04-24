package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dummy1 {

    @Autowired
    JobBuilderFactory jobs;
    @Autowired
    StepBuilderFactory steps;

    @Bean
    public Step step1() {
        return steps.get("dummy-tasklet-1")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("hello 1");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Job job() {
        return jobs.get("dummy-job-1")
                .start(step1())
                .build();
    }
}