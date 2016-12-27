package br.com.haka.domain.service;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import br.com.haka.domain.valueObject.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 20/12/16
 */

@Service
public class ManagerService {

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private Users users;

    @Autowired
    UserLockerService userLockerService;

    public boolean book(Date date, BookableArea bookableArea, User user) {
        return false;
    }

    public boolean removeUser(String apartmentManagerToken, String user) {
        return userRegisterService.remove(user);
    }

    public User createUser(String login, String pass, String name, Boolean unlocked) {
        return userRegisterService.create(login, pass, name, unlocked);
    }

    public boolean lockUser(User user) {
        return userLockerService.lock(user.getLogin());
    }

    public boolean unlockUser(User user) {
        return userLockerService.unlock(user.getLogin());
    }
}