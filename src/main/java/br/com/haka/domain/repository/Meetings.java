package br.com.haka.domain.repository;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.ApartmentManagerToken;
import br.com.haka.domain.entity.Meeting;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/12/16
 * Time: 11:55 PM
 * <p/>
 * Responsabilidade:
 */
@Repository
public class Meetings {
    private List<Meeting> meetings;

    public Meetings() {
        this.meetings = new ArrayList<Meeting>();
    }

    public boolean create(ApartmentManager apartmentManager, Date date, String local, String subject) {
        if ( apartmentManager == null || date == null || local == null || subject == null )
            return false;

        Meeting meeting = new Meeting();
        return meetings.add(meeting);
    }
}
