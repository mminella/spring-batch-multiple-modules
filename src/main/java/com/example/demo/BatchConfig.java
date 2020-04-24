package com.example.demo;

import com.example.Dummy1;
import com.example.Dummy2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing(modular = true)
public class BatchConfig {

    @Bean
    public ApplicationContextFactory getDummyJob() {
        return new GenericApplicationContextFactory(Dummy1.class);
    }

    @Bean
    public ApplicationContextFactory getJobConfig() {
        return new GenericApplicationContextFactory(Dummy2.class);
    }
}