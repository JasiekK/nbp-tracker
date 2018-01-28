package com.jkmiec.service;

import com.jkmiec.api.ExchangeRatesRestClient;
import com.jkmiec.model.ExchangeRates;
import com.jkmiec.model.ExchangeRatesRequest;
import com.jkmiec.repository.ExchangeRatesRepository;
import com.jkmiec.repository.ExchangeRatesRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExchangeRatesService implements IExchangeRatesService {

    private ExchangeRatesRepository exchangeRatesRepository;
    private ExchangeRatesRequestRepository ratesRequestRepository;

    @Autowired
    public ExchangeRatesService(ExchangeRatesRepository exchangeRatesRepository, ExchangeRatesRequestRepository ratesRequestRepository) {
        this.exchangeRatesRepository = exchangeRatesRepository;
        this.ratesRequestRepository = ratesRequestRepository;
    }

    @Override
    public ExchangeRates save(ExchangeRates exchangeRates) {
        return exchangeRatesRepository.save(exchangeRates);
    }

    @Override
    public void update() throws IOException {
        stringToXml(ExchangeRatesRestClient.getExchangeRates());
    }

    @Override
    public List<ExchangeRatesRequest> getRates() {
        return ratesRequestRepository.getBigThereByByCode();
    }

    private static void stringToXml(String xmlSource)
            throws IOException {
        java.io.FileWriter fw = new java.io.FileWriter("src/main/resources/data/my-file.xml");
        fw.write(xmlSource);
        fw.close();
    }
}
