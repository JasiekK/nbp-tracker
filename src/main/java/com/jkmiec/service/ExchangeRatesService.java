package com.jkmiec.service;

import com.jkmiec.model.ExchangeRates;
import com.jkmiec.repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRatesService implements IExchangeRatesService{

    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    public ExchangeRatesService(ExchangeRatesRepository exchangeRatesRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    @Override
    public ExchangeRates save(ExchangeRates exchangeRates) {
        return exchangeRatesRepository.save(exchangeRates);
    }
}
