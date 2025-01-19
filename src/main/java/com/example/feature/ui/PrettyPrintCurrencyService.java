package com.example.feature.ui;

import com.example.feature.currency.Currency;

/**
 *
 */
public class PrettyPrintCurrencyService {
    private static final String PRINT_TEMPLATE = "%s = %s UAH";

    public String convert(float rate, Currency currency) {
        return String.format(PRINT_TEMPLATE, currency, rate);
    }

}
