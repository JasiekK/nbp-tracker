package com.jkmiec.controller;

import com.jkmiec.service.IExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class HomeController {

    @Autowired
    private IExchangeRatesService exchangeRatesService;

    @GetMapping("/update")
    public void updateExchangeRates() throws IOException {
        exchangeRatesService.update();
    }
}
