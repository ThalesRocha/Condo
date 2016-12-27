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

    public void lock(String login) {
        User user = users.findByLogin(login);
        users.lockUser(user);
    }

    public void unlock(String login) {
        User user = users.findByLogin(login);
        users.unlockUser(user);
    }
}
