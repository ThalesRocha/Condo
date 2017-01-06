package br.com.haka;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.Guest;
import br.com.haka.domain.entity.ScheduleBookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Guests;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.service.UserBookAreaService;
import br.com.haka.domain.service.UserRegisterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hivisonmoura on 2017-01-05.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private ApartmentManagerService apartmentManagerService;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private Guests guests;

    @Autowired
    private UserBookAreaService userBookAreaService;


    private BookableArea bookableArea;


    private Date date = Calendar.getInstance().getTime();

    private Guest guest;

    private User user;



    @Test
    public void testRegisterGuest() {
        user = apartmentManagerService.createUser("IronMan", "Jarvis", "TonyStark", true);
        guest = userRegisterService.registerGuest(user, date, "SpiderMan", 123456);
        Assert.assertNotNull(guest);
        Assert.assertTrue(guest.equals(guests.findByCpf(guest.getCpf())));
        Assert.assertFalse(guest.equals(guests.findByCpf(1234)));
        System.out.println(guest.getDate());


    }

    @Test
    public void testBookArea() {
        user = apartmentManagerService.createUser("Three","Earth", "Groot", true);
        BookableArea bookableArea = apartmentManagerService.createBookableArea("Pool", 20);

        ScheduleBookableArea scheduleBookableArea = userBookAreaService.bookAnArea(user, bookableArea, date);
        Assert.assertNotNull(scheduleBookableArea);



    }
}