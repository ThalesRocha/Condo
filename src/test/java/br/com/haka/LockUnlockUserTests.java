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
    public void testLockUser(){


        //Bloqueia um usuário
        User user = apartmentManagerService.createUser("teste", "233","test", true);
        apartmentManagerService.lockUser(user);
        Assert.assertNotNull(user.getUnlocked());
        Assert.assertFalse(user.getUnlocked());




    }

    @Test //Eu como síndico devo ser capaz de desbloquear um condômino para que ele possa voltar a utilizar áreas de reserva
    public void testUnlockUser(){

        //Manda desbloquear um usuário que existe
        User user = apartmentManagerService.createUser("teste2", "233","test", false);
        apartmentManagerService.unlockUser(user);
        Assert.assertNotNull(user.getUnlocked());

        //Desbloqueio com sucesso
        Assert.assertTrue(user.getUnlocked());


        //busco o usuário desbloqueado e ele pode reservar
        //Assert.assertTrue();
        //TODO
    }
}