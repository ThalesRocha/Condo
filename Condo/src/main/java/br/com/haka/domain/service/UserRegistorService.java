package br.com.haka.domain.service;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserRegistorService {

    @Autowired
    private Users users;

    public boolean remove(String login) {
        User byLogin = users.findByLogin(login);
        return users.remove(byLogin);
    }

    public User create(String login, String pass, String name) {
        User user = User.createUser(name, login, pass);
        users.add(user);
        return users.findByLogin(login);
    }
}
