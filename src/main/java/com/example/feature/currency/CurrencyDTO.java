package com.example.feature.currency;

/**
 * DTO for ccy object
 *
 * @param ccy      ccy code
 * @param base_ccy base_ccy ccy code
 * @param buy      buy rate
 * @param sale     sale rate
 */
public record CurrencyDTO(
        // Names should be exactly the same as in JSON
        Currency ccy,
        Currency base_ccy,
        float buy,
        float sale
) {
    /**
     * Default UAH base_ccy constructor for ccy
     *
     * @param currency ccy code
     * @param buy      buy rate
     * @param sell     sale rate
     */
    public CurrencyDTO(Currency currency, float buy, float sell) {
        this(currency, Currency.UAH, buy, sell);
    }
}
