package com.jkmiec.service;

import com.jkmiec.model.ExchangeRates;

import java.io.IOException;

public interface IExchangeRatesService {
    ExchangeRates save(ExchangeRates exchangeRates);
    void update() throws IOException;
}
