package com.github.schedule.tgb.command;

import com.github.schedule.tgb.sersvice.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command{

    public static String UNKNOWN_MESSAGE = "Неизвестная команда.";

    private final SendBotMessageService sendBotMessageService;


    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
