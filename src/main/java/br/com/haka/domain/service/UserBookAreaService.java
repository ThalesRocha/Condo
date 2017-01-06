package br.com.haka.domain.service;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.ScheduleBookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.ScheduleBookableAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String userInput = "15-01-2016";
            Date date1 = formatter.parse(userInput);
            ScheduleBookableArea scheduleBookableArea1 = ScheduleBookableArea.scheduleAnBookArea(user,bookableArea,date1);
            scheduleBookableAreas.add(scheduleBookableArea1);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        if(userValidateBookService.validadeBookArea(date,bookableArea,user)){
            ScheduleBookableArea scheduleBookableArea = ScheduleBookableArea.scheduleAnBookArea(user,bookableArea,date);
            scheduleBookableAreas.add(scheduleBookableArea);
            return scheduleBookableAreas.findByAvailability(bookableArea,date);
        }
        return null;
    }
}
