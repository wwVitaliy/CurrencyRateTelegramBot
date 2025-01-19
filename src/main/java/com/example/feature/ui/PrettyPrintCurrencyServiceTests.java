package com.example.feature.ui;

import com.example.feature.currency.Currency;

public class PrettyPrintCurrencyServiceTests {
    public static void main(String[] args) {
        PrettyPrintCurrencyService myClass = new PrettyPrintCurrencyService();

        System.out.println("myClass.convert(42F, Currency.USD) = " + myClass.convert(42F, Currency.USD));
        System.out.println("myClass.convert(42F, Currency.EUR) = " + myClass.convert(43F, Currency.EUR));
    }
}
