package br.com.haka.domain.repository;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.ScheduleBookableArea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hivisonmoura on 2017-01-06.
 */
@Repository
public class ScheduleBookableAreas {

    private static List<ScheduleBookableArea> scheduleBookableAreas;


    public ScheduleBookableAreas() {
        this.scheduleBookableAreas = new ArrayList<>();
    }

    public boolean add(ScheduleBookableArea scheduleBookableArea) {
        return this.scheduleBookableAreas.add(scheduleBookableArea);
    }



    public ScheduleBookableArea findByAvailability(BookableArea bookableArea, Date date) {
        if (bookableArea != null && date != null) {
            for (ScheduleBookableArea scheduleBookableArea : this.scheduleBookableAreas) {
                if (!scheduleBookableArea.getBookableArea().equals(bookableArea)) {
                    return scheduleBookableArea;
                } else {
                    if (scheduleBookableArea.getBookableArea().equals(bookableArea) &&
                            !scheduleBookableArea.getDate().equals(date)) {
                        return scheduleBookableArea;
                    }
                }
            }
        }

        return null;
    }

    public int size() {
        return scheduleBookableAreas.size();
    }
    //TODO rename
    public ScheduleBookableArea findByName(BookableArea bookableArea, Date date) {
        if(bookableArea != null && date != null ){
            for(ScheduleBookableArea scheduleBookableArea : this.scheduleBookableAreas){
                if(scheduleBookableArea.getBookableArea().equals(bookableArea) &&
                        scheduleBookableArea.getDate().equals(date))
                    return scheduleBookableArea;
            }
        }
        return  null;
    }
}
