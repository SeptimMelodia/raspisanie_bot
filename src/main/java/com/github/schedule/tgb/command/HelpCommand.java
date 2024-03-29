package com.github.schedule.tgb.command;

import com.github.schedule.tgb.sersvice.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.schedule.tgb.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("Доступные команды:\n\n"

        + "%s - начать работу с ботом.\n"
        + "%s - остановить работу бота.\n"
        + "%s - помощь.\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
