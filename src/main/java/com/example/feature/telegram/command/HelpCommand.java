package com.example.feature.telegram.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelpCommand extends BotCommand {

    public HelpCommand() {
        super("Help", "Help Command");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage helpMessage = new SendMessage();
        helpMessage.setText("Type /start to get currency rate.");
        helpMessage.setChatId(chat.getId());
        try {
            absSender.execute(helpMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
