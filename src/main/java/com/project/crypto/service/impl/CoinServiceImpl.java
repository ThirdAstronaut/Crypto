package com.project.crypto.service.impl;

import com.project.crypto.model.CoinMarketModel;
import com.project.crypto.repository.CoinRepository;
import com.project.crypto.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by Rafał on 2017-08-30.
 */
@Service("coinService")
public class CoinServiceImpl implements CoinService {

    private final CoinRepository coinRepository;

    @Autowired
    public CoinServiceImpl(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    @Override
    public List<CoinMarketModel> findAll() {
        return (List<CoinMarketModel>) coinRepository.findAll();
    }

    @Override
    public void saveAll(List<CoinMarketModel> list) {
        coinRepository.saveAll(list);
    }

    @Override
    public Optional<CoinMarketModel> findById(Long id) {
        return coinRepository.findById(id);
    }

    @Override
    public List<CoinMarketModel> findByPriceGreaterEqual(int minPrice) {
        return (List<CoinMarketModel>) findAll().stream().filter(x -> (Double.valueOf(x.getPrice_btc()) >= minPrice));
    }

    @Override
    public List<CoinMarketModel> findByPriceLessThan(int maxPrice) {
        return (List<CoinMarketModel>) findAll().stream().filter(x -> (Double.valueOf(x.getPrice_btc()) < maxPrice));
    }

    @Override
    public List<CoinMarketModel> findByPriceSortedDecreasingly() {
        List<CoinMarketModel> list = findByPriceSortedIncreasingly();
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<CoinMarketModel> findByPriceSortedIncreasingly() {
        Comparator<CoinMarketModel> comp = Comparator.comparing(o -> Double.valueOf(o.getPrice_btc()));
        findAll().sort(comp);
        return findAll();
    }

    @Override
    public CoinMarketModel findByName(String name) {
        return coinRepository.findByName(name);
    }

}
