package com.jkmiec.controller;

import com.jkmiec.model.ExchangeRatesRequest;
import com.jkmiec.service.IExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiagramsController {

    @Autowired
    private IExchangeRatesService exchangeRatesService;

    @GetMapping("/test")
    public List<ExchangeRatesRequest> getRates() {
        return exchangeRatesService.getRates();
    }

}
