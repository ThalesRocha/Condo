package br.com.haka.domain.repository;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.ApartmentManagerToken;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * <p/>
 * User: Tiago Magalhães
 * Date: 12/12/16
 * Time: 11:44 PM
 * <p/>
 * Responsabilidade:
 */
@Repository
public class ApartmentManagers {

    List<ApartmentManager> apartmentManagers;

    public ApartmentManagers() {
        this.apartmentManagers = new ArrayList<ApartmentManager>();
    }


    public ApartmentManager findByToken(ApartmentManagerToken apartmentManagerToken) {

        for (ApartmentManager apartmentManager : apartmentManagers){
            if ( apartmentManager.equals(apartmentManagerToken)){
                return apartmentManager;
            }

        }

          return null;
    }
}
