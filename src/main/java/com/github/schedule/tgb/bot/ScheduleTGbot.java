package com.github.schedule.tgb.bot;

import com.github.schedule.tgb.command.CommandContainer;
import com.github.schedule.tgb.sersvice.SendBotMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ScheduleTGbot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
    private final CommandContainer commandContainer;

    public ScheduleTGbot() {
        this.commandContainer = new CommandContainer(new SendBotMessageService(this));
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                // реализация процесса не входящих в команды
            }
        }
    }
}
