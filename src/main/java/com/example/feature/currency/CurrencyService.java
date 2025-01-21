package com.example.feature.currency;

/**
 *  Service that returns a currency (USD or EUR) rate to UAH .
 */
public interface CurrencyService {
    float getBuyRate(Currency c);
    float getSellRate(Currency c);
}
