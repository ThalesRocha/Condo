package br.com.haka.domain.service;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.ApartmentManagerToken;
import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.ApartmentManagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/12/16
 * Time: 11:05 PM
 * <p/>
 * Responsabilidade:
 */
@Service
public class ApartmentManagerService {

    @Autowired
    private ApartmentManagers apartmentManagers;

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserLockerService userLockerService;

    @Autowired
    private BookableAreaCreatorService bookableAreaCreatorService;


    private User user;



    public boolean scheduleMeeting(ApartmentManagerToken apartmentManagerToken, Date date, String local, String subject) {
        // verificar se o síndico é síndico mesmo
        ApartmentManager apartmentManager = apartmentManagers.findByToken(apartmentManagerToken);
        //criar uma meeting
        return meetingService.createMeeting(apartmentManager, date, local, subject);
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

    public BookableArea createBookableArea( String name, int capacity) {
        return bookableAreaCreatorService.create(name, capacity);
    }
}
