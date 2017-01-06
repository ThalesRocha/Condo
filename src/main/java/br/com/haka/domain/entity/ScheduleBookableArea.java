package br.com.haka.domain.entity;

import java.util.Date;

/**
 * Created by hivisonmoura on 2017-01-06.
 */
public class ScheduleBookableArea {

    private BookableArea bookableArea;
    private Date date;
    private User user;

    private ScheduleBookableArea(User user, BookableArea bookableArea, Date date) {
        this.bookableArea = bookableArea;
        this.date = date;
        this.user = user;
    }

    public static ScheduleBookableArea scheduleAnBookArea(User user, BookableArea bookableArea, Date date) {
        return new ScheduleBookableArea(user, bookableArea, date);
    }

    public BookableArea getBookableArea() {
        return bookableArea;
    }

    public void setBookableArea(BookableArea bookableArea) {
        this.bookableArea = bookableArea;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
