package com.jkmiec.service;

import com.jkmiec.api.ExchangeRatesRestClient;
import com.jkmiec.model.ExchangeRates;
import com.jkmiec.repository.ExchangeRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExchangeRatesService implements IExchangeRatesService {

    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    public ExchangeRatesService(ExchangeRatesRepository exchangeRatesRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
    }

    @Override
    public ExchangeRates save(ExchangeRates exchangeRates) {
        return exchangeRatesRepository.save(exchangeRates);
    }

    @Override
    public void update() throws IOException {
        stringToXml(ExchangeRatesRestClient.getExchangeRates());
    }

    private static void stringToXml(String xmlSource)
            throws IOException {
        java.io.FileWriter fw = new java.io.FileWriter("src/main/resources/data/my-file.xml");
        fw.write(xmlSource);
        fw.close();
    }
}
