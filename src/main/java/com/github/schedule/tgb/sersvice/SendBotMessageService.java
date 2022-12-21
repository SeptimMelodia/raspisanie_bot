package com.github.schedule.tgb.sersvice;

import com.github.schedule.tgb.bot.ScheduleTGbot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageService implements SendBotMessageServiceInterface{

    private final ScheduleTGbot scheduleTGbot;

    @Autowired
    public SendBotMessageService(ScheduleTGbot scheduleTGbot) {
        this.scheduleTGbot = scheduleTGbot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            scheduleTGbot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
