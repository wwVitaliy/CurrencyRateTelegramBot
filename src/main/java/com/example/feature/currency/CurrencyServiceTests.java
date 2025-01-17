package com.example.feature.currency;

public class CurrencyServiceTests {
    public static void main(String[] args) {
        CurrencyService service = new PrivatBankCurrencyService();

        System.out.println("service.getBuyRate(Currency.USD) = " + service.getBuyRate(Currency.USD));
        System.out.println("service.getSellRate(Currency.USD) = " + service.getSellRate(Currency.USD));

        System.out.println("service.getBuyRate(Currency.EUR) = " + service.getBuyRate(Currency.EUR));
        System.out.println("service.getSellRate(Currency.EUR) = " + service.getSellRate(Currency.EUR));

        System.out.println("service.getBuyRate(Currency.UAH) = " + service.getBuyRate(Currency.UAH));
        System.out.println("service.getSellRate(Currency.UAH) = " + service.getSellRate(Currency.UAH));

    }
}
