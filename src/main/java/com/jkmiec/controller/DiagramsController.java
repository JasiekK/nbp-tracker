package com.jkmiec.controller;

import com.jkmiec.model.ExchangeRatesRequest;
import com.jkmiec.service.IExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class DiagramsController {

    @Autowired
    private IExchangeRatesService exchangeRatesService;

    @GetMapping("/test")
    public List<ExchangeRatesRequest> getRates() {
        return exchangeRatesService.getRates();
    }

    @GetMapping("/update")
    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "rates updated")
    public void updateExchangeRates() throws IOException {
        exchangeRatesService.update();
    }

}
