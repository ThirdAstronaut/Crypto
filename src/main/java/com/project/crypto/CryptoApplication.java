package com.project.crypto;

import com.project.crypto.controller.CoinsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableCaching
@EnableBatchProcessing
public class CryptoApplication {
    private final CoinsController coinsController;

    @Autowired
    public CryptoApplication(CoinsController coinsController) {
        this.coinsController = coinsController;
    }

    private final Logger logger = LoggerFactory.getLogger((getClass()));

    public static void main(String[] args) {
        SpringApplication.run(CryptoApplication.class, args);
    }

    @Scheduled(initialDelay = 1_000, fixedRate = 1_000)
    public void run() {
        logger.info("Num of coins: " + coinsController.saveCoinsInDB().size());
    }


    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Fetch new data-");
        executor.initialize();
        return executor;
    }
}