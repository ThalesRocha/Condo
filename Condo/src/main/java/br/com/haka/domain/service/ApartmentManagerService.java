package br.com.haka.domain.service;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.ApartmentManagerToken;
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

    public boolean scheduleMeeting(ApartmentManagerToken apartmentManagerToken, Date date, String local, String subject) {
        // verificar se o sindico é sindico mesmo
        ApartmentManager apartmentManager = apartmentManagers.findByToken(apartmentManagerToken);
        //criar uma meeting
        return meetingService.createMeeting(apartmentManager, date, local, subject);
    }
}
