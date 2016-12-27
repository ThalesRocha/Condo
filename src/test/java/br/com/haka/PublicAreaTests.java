package br.com.haka;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.service.ApartmentManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 20/12/16
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicAreaTests {

    @Autowired
    private ApartmentManagerService apartmentManagerService;

    @Autowired
    private Users users;

    @Autowired
    private PublicArea publicArea;

    User userTest = apartmentManagerService.createUser("Emperor Palpatine", "theBadOne@deathstar.com", "123");
    publicArea = publicAreaManagerService.createPublicArea(PublicAreas.CHURRASQUEIRA);

    @Test //Eu como condômino deve ser capaz de reservar áreas comuns
    public void testBookPublicArea(Date date, PublicArea publicArea, User userTest) {
        Boolean booked = PublicAreaManagerService.book(publicArea);
        Assert.assertNotNull(booked);
        Assert.assertTrue(booked);
    }
}

