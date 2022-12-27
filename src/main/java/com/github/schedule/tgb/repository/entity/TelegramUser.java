package com.github.schedule.tgb.repository.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tg_user")
public class TelegramUser {
    @Id
    @Column(name = "tg_user")
    private String chatId;

    @Column(name = "active")
    private boolean active;

    public void setId(String id) {
        this.chatId = id;
    }

    public String getId() {
        return chatId;
    }
}
