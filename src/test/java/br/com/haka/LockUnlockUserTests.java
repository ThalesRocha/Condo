package br.com.haka;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.service.ApartmentManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.haka.domain.valueObject.BookableAreas;

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
public class LockUnlockUserTests {

    @Autowired
    private ApartmentManagerService apartmentManagerService;

    @Autowired
    private Users users;

    @Autowired
    private BookableArea bookableArea;

    User userTest = apartmentManagerService.createUser("theBadOne@deathstar.com", "Emperor Palpatine", "123", true);

    @Test //Eu como síndico devo ser capaz de bloquear um condômino para que ele não possa utilizar áreas de reserva
    public void testeLockUser(){


        //Bloqueia um usuário
        Boolean unlocked = apartmentManagerService.lockUser(userTest);
        Assert.assertFalse(userTest.getUnlocked());

        //busco o usuário bloqueado e ele não pode reservar
        Assert.assertFalse(userTest.bookPublicArea(PublicAreas.CHURRASQUEIRA));
    }

    @Test //Eu como síndico devo ser capaz de desbloquear um condômino para que ele possa voltar a utilizar áreas de reserva
    public void testUnlockUser(){

        //Manda desbloquear um usuário que existe
        Boolean unlocked = apartmentManagerService.unlockUser(userTest);
        Assert.assertNotNull(userTest.getUnlocked());

        //Desbloqueio com sucesso
        Assert.assertTrue(userTest.getUnlocked());

        //busco o usuário desbloqueado e ele pode reservar
        //Assert.assertTrue();
        //TODO
    }
}