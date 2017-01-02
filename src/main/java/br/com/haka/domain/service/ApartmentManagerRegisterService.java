package br.com.haka.domain.service;

import br.com.haka.domain.entity.ApartmentManager;
import br.com.haka.domain.entity.ApartmentManagerToken;
import br.com.haka.domain.repository.ApartmentManagers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hivisonmoura on 2017-01-02.
 */
@Service
public class ApartmentManagerRegisterService {

    @Autowired
    private ApartmentManagers apartmentManagers;

    public ApartmentManager create(ApartmentManagerToken token, String name){
        ApartmentManager apartmentManager = ApartmentManager.createApartmentManager(token,name);
        apartmentManagers.add(apartmentManager);
        return apartmentManagers.findByToken(token);
    }
}
