package br.com.haka;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.valueObject.BookableAreas;
import br.com.haka.domain.repository.Users;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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

    @Autowired
    private BookableAreas bookableAreas;

    User userTest = apartmentManagerService.createUser("theBadOne@deathstar.com", "Emperor Palpatine", "123", true);
    bookableArea = bookableAreaManagerService.createBookableArea(bookableArea.CHURRASQUEIRA);

    @Test //Eu como condômino deve ser capaz de reservar áreas comuns
    public void testbookArea(Date date, BookableAreas bookableArea, User userTest) {
        Boolean booked = BookableAreaManagerService.book(bookableArea);
        Assert.assertNotNull(booked);
        Assert.assertTrue(booked);
    }
}

