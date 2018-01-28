package com.jkmiec.service;

import com.jkmiec.model.ExchangeRates;
import com.jkmiec.model.ExchangeRatesRequest;

import java.io.IOException;
import java.util.List;

public interface IExchangeRatesService {
    ExchangeRates save(ExchangeRates exchangeRates);
    void update() throws IOException;
    List<ExchangeRatesRequest> getRates();
}
