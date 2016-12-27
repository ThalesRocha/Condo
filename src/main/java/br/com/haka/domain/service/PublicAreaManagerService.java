package br.com.haka.domain.service;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.haka.domain.repository.Users;
import br.com.haka.domain.valueObject.*;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 20/12/16
 */

@Service
public class PublicAreaManagerService {

    @Autowired
    private UserRegistorService userRegistorService;

    @Autowired
    private Users users;

    public boolean book(Date date, PublicAreas publicArea, User user) {
        //
        ApartmentManager apartmentManager = apartmentManagers.findByToken(apartmentManagerToken);
        //criar uma meeting
        return meetingService.createMeeting(apartmentManager, date, local, subject);
    }

    public boolean removeUser(String apartmentManagerToken, String user) {
        return userRegistorService.remove(user);
    }

    public User createUser(String login, String pass, String name, Boolean unlocked) {
        return userRegistorService.create(login, pass, name, unlocked);
    }

    public boolean lockUser(User user) {
        return UserLockerService.lock(user.getLogin());
    }

    public boolean unlockUser(User user) {
        return UserLockerService.unlock(user.getLogin());
    }
}