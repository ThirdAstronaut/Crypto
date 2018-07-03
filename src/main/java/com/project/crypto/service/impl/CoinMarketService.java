package com.project.crypto.service.impl;

import com.project.crypto.model.CoinMarketModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by Rafał on 2017-09-03.
 */

@Service("coinMarketService")
public class CoinMarketService {

    private static final Logger logger = LoggerFactory.getLogger(CoinMarketService.class);
    private final RestTemplate restTemplate;

    @Autowired
    public CoinMarketService(RestTemplateBuilder restTemplatebuilder) {
        this.restTemplate = restTemplatebuilder.build();
    }

    @Async
    //TODO validation on number given
    public CompletableFuture<List<CoinMarketModel>> fetchData(int number) throws InterruptedException {
        logger.info("Number of data to fetch");
        logger.info("Fetch new data [" + new Date().getTime() + "]");
        String url = String.format("https://api.coinmarketcap.com/v1/ticker/?limit=%d", number);
        List<CoinMarketModel> resultList = Arrays.asList(restTemplate.getForObject(url, CoinMarketModel[].class));

        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);


        return CompletableFuture.completedFuture(resultList);

    }
}



