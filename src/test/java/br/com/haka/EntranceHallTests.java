package br.com.haka;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.Guest;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.service.ApartmentManagerService;
import br.com.haka.domain.service.EntranceHallService;
import br.com.haka.domain.service.UserRegisterService;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ObjectValue.Constants;

import static org.junit.Assert.assertTrue;

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
    
    @Autowired
    private EntranceHallService entranceHallService;

	Date guestDate = Calendar.getInstance().getTime();
	Date entryDate = Calendar.getInstance().getTime();
	Date exitDate;
	String guestName = Constants.GUEST_NAME;
	String guestRG = Constants.GUEST_RG;

    @Test //Eu como portaria devo ser capaz de registrar entrada e saída de visitantes
    public void test_registerEntryGuest(){

        User apartmentOwner = apartmentManagerService.createUser("smash","123", "Hulk", true);
        guest = userRegisterService.registerGuest(apartmentOwner, guestDate, "Test", guestRG);
        
        assertTrue(entranceHallService.registerGuestEntry(apartmentOwner, guestName, guestRG, entryDate));
    }


}
