package com.project.crypto.service;


import com.project.crypto.model.CoinMarketModel;

import java.util.List;
import java.util.Optional;

/**
 * Created by Rafał on 2017-08-30.
 */
public interface CoinService {
    List<CoinMarketModel> findAll();

    void saveAll(List<CoinMarketModel> list);

    Optional<CoinMarketModel> findById(Long id);

    List<CoinMarketModel> findByPriceGreaterEqual(int minPrice);

    List<CoinMarketModel> findByPriceLessThan(int maxPrice);

    List<CoinMarketModel> findByPriceSortedDecreasingly();

    List<CoinMarketModel> findByPriceSortedIncreasingly();

    CoinMarketModel findByName(String name);
}