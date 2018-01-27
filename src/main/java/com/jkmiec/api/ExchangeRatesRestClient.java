package com.jkmiec.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ExchangeRatesRestClient {

    private static final String URL = "http://api.nbp.pl/api/exchangerates/tables/a/last/20/?format=xml";
    private static OkHttpClient client = new OkHttpClient();

    public static String getExchangeRates() throws IOException {

        Request request = new Request.Builder()
                .url(URL)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }

}
