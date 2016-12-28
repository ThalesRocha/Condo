package br.com.haka.domain.service;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 26/12/16
 */

@Service
public class UserLockerService {

    @Autowired
    private Users users;

    public boolean lock(String login) {
        User user = users.findByLogin(login);
        return users.lockUser(user);
    }

    public boolean unlock(String login) {
        User user = users.findByLogin(login);
        return users.unlockUser(user);
    }
}
