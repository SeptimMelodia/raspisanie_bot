package com.github.schedule.tgb.service;

import com.github.schedule.tgb.bot.ScheduleTGbot;
import com.github.schedule.tgb.sersvice.SendBotMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private ScheduleTGbot scheduleTGbot;

    @BeforeEach
    public void init() {
        scheduleTGbot = Mockito.mock(ScheduleTGbot.class);
        sendBotMessageService = new SendBotMessageService(scheduleTGbot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {

        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

       sendBotMessageService.sendMessage(chatId, message);

       Mockito.verify(scheduleTGbot).execute(sendMessage);
    }
}
