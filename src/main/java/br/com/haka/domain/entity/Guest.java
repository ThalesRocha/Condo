package br.com.haka.domain.entity;

/**
 * Created by hivisonmoura on 2017-01-03.
 */
public class Guest {
    private String name;
    private int cpf;
    private User user;

    public Guest(String name, int cpf, User user) {
        this.name = name;
        this.cpf = cpf;
        this.user = user;
    }

    public static Guest createGuest(String  name, int cpf, User user) {
        return new Guest(name, cpf, user);
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
}
