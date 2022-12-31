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

    /*@Column(name = "tg_name")
    private String tgName;

    @Column(name = "irl_name")
    private String userName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
*/
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

/*    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
*/
    public String getChatId() {
        return chatId;
    }

    public boolean isActive() {
        return active;
    }

/*    public String getTgName() {
        return tgName;
    }

    public String getUserName() {
        return userName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
 */
}
