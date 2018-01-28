package com.jkmiec.controller;

import com.jkmiec.service.IExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private IExchangeRatesService exchangeRatesService;

    @GetMapping("/update")
    public void updateExchangeRates() throws IOException {
        exchangeRatesService.update();
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
