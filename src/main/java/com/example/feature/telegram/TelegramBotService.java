package com.example.feature.telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotService {
    private CurrencyTelegramBot currencyTelegramBot;

    public TelegramBotService(){
        currencyTelegramBot = new CurrencyTelegramBot(BotConstants.BotTocken);

        try{
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(currencyTelegramBot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
