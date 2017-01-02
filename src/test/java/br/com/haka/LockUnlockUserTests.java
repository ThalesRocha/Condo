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
public class LockUnlockUserTests {

    @Autowired
    private ApartmentManagerService apartmentManagerService;

    @Test //Eu como síndico devo ser capaz de bloquear um condômino para que ele não possa utilizar áreas de reserva
    public void testLockUser() {

        User userTest = apartmentManagerService.createUser("theBadOne@deathstar.com", "123", "Emperor Palpatine", true);
        Assert.assertNotNull(userTest.getName());

        //Bloqueia um usuário
        apartmentManagerService.lockUser(userTest);
        Assert.assertFalse(userTest.getUnlocked());

        //busco o usuário bloqueado e ele não pode reservar
        //Assert.assertFalse(userBookService.bookArea(dateTest, bookableArea, userTest));
    }



    @Test //Eu como síndico devo ser capaz de desbloquear um condômino para que ele possa voltar a utilizar áreas de reserva
    public void testUnlockUser(){
        User userTest = apartmentManagerService.createUser("theBadOne@deathstar.com", "123", "Emperor Palpatine", false);

        //Desbloqueia um usuário
        apartmentManagerService.unlockUser(userTest);
        Assert.assertTrue(userTest.getUnlocked());
    }

}