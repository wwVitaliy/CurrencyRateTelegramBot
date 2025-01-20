package com.example.feature.telegram.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class StartCommand extends BotCommand {
    public StartCommand() {
        super("Start", "Start Command");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String startTest = "What currency rate would you like to get?";
        SendMessage message = new SendMessage();
        message.setText(startTest);
        message.setChatId(chat.getId());

        // Create inline buttons
        InlineKeyboardButton usd = InlineKeyboardButton.builder().text("USD").callbackData("USD").build();
        InlineKeyboardButton eur = InlineKeyboardButton.builder().text("EUR").callbackData("EUR").build();

        // Create inline keyboard
        InlineKeyboardMarkup keyboardMarkup = InlineKeyboardMarkup
                .builder()
                .keyboard(List.of(List.of(usd, eur)))
                .build();

        // Add keyboard to reply message
        message.setReplyMarkup(keyboardMarkup);

        // Execute message in bot
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
