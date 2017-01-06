package br.com.haka;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.Guest;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.service.UserRegisterService;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by hivisonmoura on 2017-01-05.
 */
public class EntranceHallTests {

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private Guest guest;



    @Autowired
    private ApartmentManagerService apartmentManagerService;




    @Test //Eu como portaria devo ser capaz de registrar entrada e saída de visitantes
    public void registerEntryExitGuest(){
        //TODO finalize task

        /*
         * For register a guest the system need first have an user already registered, because a guest is always associated
         * to an user.
         */
        //User user = apartmentManagerService.createUser("smash","123", "Hulk", true);
        //guest = userRegisterService.registerGuest(user, date, "Teste",123);



    }


}
