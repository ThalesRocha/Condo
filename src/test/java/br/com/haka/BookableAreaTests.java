package br.com.haka;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.valueObject.BookableAreas;
import br.com.haka.domain.repository.Users;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.PublicAreas;
import br.com.haka.domain.repository.Users;
import br.com.haka.domain.service.ApartmentManagerService;

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
    //bookableArea = publicAreaManagerService.createPublicArea(publicArea.CHURRASQUEIRA);

    @Test //Eu como condômino deve ser capaz de reservar áreas comuns
    public void testBookPublicArea(Date date, BookableArea bookableArea, User userTest) {
//        Boolean booked = publicAreaManagerService.book(publicArea);
//        Assert.assertNotNull(booked);
//        Assert.assertTrue(booked);
    	//TODO
    }
}

