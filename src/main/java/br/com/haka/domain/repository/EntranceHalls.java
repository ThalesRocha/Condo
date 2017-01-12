package br.com.haka.domain.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.haka.domain.entity.EntranceHall;
import br.com.haka.domain.entity.Guest;

public class EntranceHalls {

	private List<EntranceHall> entranceHalls;
	
	public EntranceHalls(){
		entranceHalls = new ArrayList<EntranceHall>();
	}
	
	public boolean addGuestEntry(Guest guest){
		return false;
	}
	
	public Guest findByRG(String rg){
		for (int i=0; i< entranceHalls.size(); i++){
			if( entranceHalls.get(i).getGuest().getRg().equals(rg)){
				return entranceHalls.get(i).getGuest();
			}
		}
		return null; 
	}
}
