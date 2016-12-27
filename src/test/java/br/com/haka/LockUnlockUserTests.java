package br.com.haka;

import java.br.com.haka.domain.entity.User;
import java.br.com.haka.domain.service.ApartmentManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.br.com.haka.domain.valueObject.PublicAreas;

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

    User userTest = apartmentManagerService.createUser("Emperor Palpatine", "theBadOne@deathstar.com", "123");

    @Test //Eu como síndico devo ser capaz de bloquear um condômino para que ele não possa utilizar áreas de reserva
    public void testeLockUser(){

        //Manda bloquear um usuário que não existe pelo identificar login
        Boolean unlocked = ApartamentManagerService.lockUser("obiwanKenobi1977@tatooine.com");
        Assert.assertNull(user.getUnlocked());

        //Manda bloquear um usuário que existe pelo identificar login
        unlocked = ApartamentManagerService.lockUser("theBadOne@deathstar.com");
        Assert.assertNotNull(userTest.getUnlocked());

        //Bloqueio com sucesso
        Assert.assertFalse(userTest.getUnlocked());

        //busco o usuário bloqueado e ele não pode reservar
        Assert.assertFalse(userTest.bookPublicArea(PublicAreas.CHURRASQUEIRA));
    }

    @Test //Eu como síndico devo ser capaz de desbloquear um condômino para que ele possa voltar a utilizar áreas de reserva
    public void testUnlockUser(){

        //Manda desbloquear um usuário que não existe
        Boolean unlocked = ApartamentManagerService.unlockUser("obiwanKenobi1977@tatooine.com");
        Assert.assertNull(userTest.getUnlocked());

        //Manda desbloquear um usuário que existe
        unlocked = ApartamentManagerService.unlockUser("theBadOne@deathstar.com");
        Assert.assertNotNull(userTest.getUnlocked());

        //Desbloqueio com sucesso
        Assert.assertTrue(userTest.getUnlocked());

        //busco o usuário desbloqueado e ele pode reservar
        Assert.assertTrue(userTest.bookPublicArea(PublicAreas.CHURRASQUEIRA));
    }
}

