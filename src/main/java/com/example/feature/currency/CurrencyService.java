package com.example.feature.currency;

/**
 *  Service that returns a currency (USD or EUR) to UAH rate.
 */
public interface CurrencyService {
    float getBuyRate(Currency c);
    float getSellRate(Currency c);
}
