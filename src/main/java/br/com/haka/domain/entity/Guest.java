package br.com.haka.domain.entity;

import java.util.Date;

/**
 * Created by hivisonmoura on 2017-01-03.
 */
public class Guest {
    private String name;
    private int cpf;
    private User user;
    private Date date;

    public Guest(String name, int cpf, User user, Date date) {
        this.name = name;
        this.cpf = cpf;
        this.user = user;
        this.date = date;
    }

    public static Guest createGuest(String  name, int cpf, User user, Date date) {
        return new Guest(name, cpf, user, date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
