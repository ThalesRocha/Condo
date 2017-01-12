package br.com.haka.domain.repository;

import br.com.haka.domain.entity.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hivisonmoura on 2017-01-03.
 */
@Repository
public class Guests {

    private static List<Guest> guests;


    public Guests() {
        this.guests = new ArrayList<>();
    }

    public boolean add(Guest guest) {
        return this.guests.add(guest);
    }

    public Guest findByRG(String rg) {
        if(rg.isEmpty()) {
            for (Guest guest : this.guests){
                if(guest.getRg().equals(rg))
                    return guest;
            }
        }
        return null;
    }


}
