package com.example.feature.telegram;

import com.example.feature.currency.Currency;
import com.example.feature.currency.CurrencyService;
import com.example.feature.currency.PrivatBankCurrencyService;
import com.example.feature.telegram.command.HelpCommand;
import com.example.feature.telegram.command.StartCommand;
import com.example.feature.ui.PrettyPrintCurrencyService;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class CurrencyTelegramBot extends TelegramLongPollingCommandBot {
    private CurrencyService currencyService;
    private PrettyPrintCurrencyService prettyPrintCurrencyService;

    public CurrencyTelegramBot(String botToken) {
        super(botToken);
        currencyService = new PrivatBankCurrencyService();
        prettyPrintCurrencyService = new PrettyPrintCurrencyService();

        // Register commands in the bot
        register(new StartCommand());
        register(new HelpCommand());
    }


    @Override
    public String getBotUsername() {
        return BotConstants.BotName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            String callbackQuery = update.getCallbackQuery().getData();

            Currency currency = Currency.valueOf(callbackQuery);
            String currencyRatePrint = prettyPrintCurrencyService.convert(currencyService.getBuyRate(currency), currency);

            SendMessage message = new SendMessage();
            message.setText(currencyRatePrint);
            message.setChatId(update.getCallbackQuery().getMessage().getChatId());

            // Execute message in bot
            try {
                execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
        if (update.hasMessage()) {
            String message = update.getMessage().getText();
            String responseText = "You typed: \""
                    + message
                    + "\"";
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(responseText);
            sendMessage.setChatId(update.getMessage().getChatId());

            // Execute message in bot
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("No command here!");
        }
    }
}
