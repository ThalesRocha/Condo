package br.com.haka.domain.service;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.ApartmentManagerToken;
import br.com.haka.domain.repository.Meetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/12/16
 * Time: 11:54 PM
 * <p/>
 * Responsabilidade:
 */
@Service
public class MeetingService {

    @Autowired
    private Meetings meetings;


    public boolean createMeeting(ApartmentManager apartmentManager, Date date, String local, String subject) {
        return meetings.create(apartmentManager, date, local, subject);
    }
}
