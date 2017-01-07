package br.com.haka.domain.service;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.ScheduleBookableAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 26/12/16
 */

@Service
public class UserValidateBookService {

    @Autowired
    private br.com.haka.domain.repository.BookableAreas bookableAreas;
    @Autowired
    private ScheduleBookableAreas scheduleBookableAreas;


    public Boolean validateBookArea(Date date, BookableArea bookableArea, User user) {
        if (user.getUnlocked()) {
            if(scheduleBookableAreas.size() == 0){
                return true;
            }else{
                if (bookableAreas.findByName(bookableArea.getName()) != null) {
                    if (scheduleBookableAreas.findByAvailability(bookableArea, date) != null)
                        return true;
                }
            }

        }
        return false;
    }
}
