package br.com.haka.domain.service;

import br.com.haka.domain.entity.Guest;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Guests;
import br.com.haka.domain.repository.Users;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/15/16
 * Time: 11:27 PM
 * <p/>
 * Responsabilidade:
 */
@Service
public class UserRegisterService {

    @Autowired
    private Users users;

    @Autowired
    private Guests guests;

    public boolean remove(String login) {
        User byLogin = users.findByLogin(login);
        return users.remove(byLogin);
    }

    public User create(String login, String pass, String name, Boolean unlocked) {
        User user = User.createUser(name, login, pass, unlocked);
        users.add(user);
        return users.findByLogin(login);
    }

    public Guest registerGuest(User user, Date date, String name, int cpf) {
        Guest guest = Guest.createGuest(name, cpf, user);
        guests.add(guest);
        return guests.findByCpf(cpf);
    }
}
