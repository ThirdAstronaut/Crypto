package com.project.crypto.repository;

import com.project.crypto.model.CoinMarketModel;
import com.project.crypto.service.impl.CoinMarketService;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Rafał on 2017-08-30.
 */

public interface CoinRepository extends CrudRepository<CoinMarketModel, Long> {
    CoinMarketModel findByName(String name);

    void save(CoinMarketService x);

    //void save(List<CoinMarketService> list);
}