package br.com.haka.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.haka.domain.entity.Guest;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.EntranceHalls;
import br.com.haka.domain.repository.Users;

public class EntranceHallService {

    @Autowired
    private EntranceHalls entranceHalls;
	
	public boolean registerGuestEntry(User apartmentOwner, String guestName, String guestRG, Date entryDate){
		
		Guest entryGuest = entranceHalls.findByRG(guestRG);
		
		// Look for an already existent guest, if it exists no point in creating another one, just register entry
		if(entryGuest != null){
			return callAddGuestEntry(entryGuest);
		}
		else{
			entryGuest = Guest.createGuest(guestName, guestRG, apartmentOwner, entryDate);
			return callAddGuestEntry(entryGuest);
		}
	}
	
	private boolean callAddGuestEntry(Guest entryGuest){
		if(entranceHalls.addGuestEntry(entryGuest))
			return true;
		else
			return false;
	}
}
