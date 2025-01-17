package com.example.feature.currency;

import com.google.gson.Gson;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Service that returns a ccy to UAH rate from PrivatBank API.
 */
public class PrivatBankCurrencyService implements CurrencyService {
    /**
     * PrivatBank API for ccy to UAH rate for cash in JSON
     */
    public static final String PRIVAT_API_5 = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";

    /**
     * Gson object with prettyPrinting to work with JSON.
     */
    public static final Gson GSON = new Gson().newBuilder().setPrettyPrinting().create();

    /**
     * Returns buy rate for defined ccy from API.
     *
     * @param c Currency to get rate for
     * @return Buy rate for defined ccy from API
     */
    @Override
    public float getBuyRate(Currency c) {
        if (c == Currency.UAH) {
            return 1F;
        }

        CurrencyDTO[] ratesFromApi = getRatesFromApi();
        for (CurrencyDTO currencyDTO : ratesFromApi) {
            if (currencyDTO.ccy() == c) {
                return currencyDTO.buy();
            }
        }
        return -1F;
    }

    /**
     * Returns sale rate for defined ccy from API.
     *
     * @param c Currency to get rate for
     * @return Sell rate for defined ccy from API
     */
    @Override
    public float getSellRate(Currency c) {
        if (c == Currency.UAH) {
            return 1F;
        }

        CurrencyDTO[] ratesFromApi = getRatesFromApi();

        for (CurrencyDTO currencyDTO : ratesFromApi) {
            if (currencyDTO.ccy() == c) {
                return currencyDTO.sale();
            }
        }
        return -1F;
    }

    /**
     * Gets currencies rates from API and converts them to ccy DTO.
     *
     * @return Currencies rates from API as CurrencyDTO[].
     */
    private CurrencyDTO[] getRatesFromApi() {
        String rateJSON;
        try {
            rateJSON = Jsoup.connect(PRIVAT_API_5)
                    .ignoreContentType(true)    //  todo ?
                    .get()
                    .body()
                    .text();
        } catch (IOException e) {
            throw new RuntimeException(e);  // todo ?
        }
        return GSON.fromJson(rateJSON, CurrencyDTO[].class);
    }
}
