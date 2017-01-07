package br.com.haka.domain.service;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.ScheduleBookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.ScheduleBookableAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by hivisonmoura on 2017-01-06.
 */
@Service
public class UserBookAreaService {

    @Autowired
    private UserValidateBookService userValidateBookService;

    @Autowired
    private ScheduleBookableAreas scheduleBookableAreas;





    public ScheduleBookableArea bookAnArea(User user, BookableArea bookableArea, Date date) {
    /*
     * Create by hard code a schedule book area for test proposes only
     */
    /*


*/

        if(userValidateBookService.validateBookArea(date,bookableArea,user)){
            ScheduleBookableArea scheduleBookableArea = ScheduleBookableArea.scheduleAnBookArea(user,bookableArea,date);
            scheduleBookableAreas.add(scheduleBookableArea);
            return scheduleBookableAreas.findByName(bookableArea,date);
        }
        return null;
    }
}
