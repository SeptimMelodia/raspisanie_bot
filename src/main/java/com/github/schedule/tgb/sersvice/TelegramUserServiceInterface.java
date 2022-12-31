package com.github.schedule.tgb.sersvice;

import com.github.schedule.tgb.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserServiceInterface {

    void save(TelegramUser telegramUser);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId(String chatID);
}
