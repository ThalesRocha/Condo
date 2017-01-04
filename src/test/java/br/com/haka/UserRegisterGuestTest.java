package br.com.haka;

import br.com.haka.domain.entity.Guest;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Guests;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.service.UserRegisterService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by hivisonmoura on 2017-01-03.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegisterGuestTest {

    @Autowired
    private ApartmentManagerService apartmentManagerService;

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private Guests guests;

    private Guest guest;

    private User user;


    @Test
    public void testRegisterGuest(){
        user = apartmentManagerService.createUser("hmoura", "123", "Test", true);
        Date date = Calendar.getInstance().getTime();
        guest = userRegisterService.registerGuest(user ,date,"Visitante", 123456);
        Assert.assertNotNull(guest);
        Assert.assertTrue(guest.equals(guests.findByCpf(guest.getCpf())));
        Assert.assertFalse(guest.equals(guests.findByCpf(1234)));


    }

}
