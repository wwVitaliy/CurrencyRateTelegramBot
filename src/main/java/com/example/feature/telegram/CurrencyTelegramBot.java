package com.example.feature.telegram;

import com.example.feature.telegram.command.StartCommand;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public class CurrencyTelegramBot extends TelegramLongPollingCommandBot {

    public CurrencyTelegramBot(String botToken) {
        super(botToken);
        register(new StartCommand());
    }


    @Override
    public String getBotUsername() {
        return BotConstants.BotName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        System.out.println("No command here!");
    }
}
