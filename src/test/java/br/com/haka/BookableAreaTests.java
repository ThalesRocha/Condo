package br.com.haka;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.service.UserValidateBookService;
import br.com.haka.domain.valueObject.BookableAreas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 20/12/16
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookableAreaTests {

        @Autowired
        private ApartmentManagerService apartmentManagerService;

        @Autowired
        private Users users;


        private BookableAreas bookableAreas;

        @Autowired
        private UserValidateBookService userBookService;


    Date date = Calendar.getInstance().getTime();



    @Test //Eu como condômino deve ser capaz de reservar áreas comuns
        public void testBookAreaWithUnlockUser() {
            User user = apartmentManagerService.createUser("hmoura", "12345","Hivison", true);
            Assert.assertTrue(userBookService.bookArea(date, bookableAreas.PISCINA, user));

        }

        @Test
        public void testBookAreaWithLockUser(){
            User user = apartmentManagerService.createUser("test", "12q32w", "test", false);
           Assert.assertFalse(userBookService.bookArea(date, bookableAreas.PISCINA, user));

        }
}

