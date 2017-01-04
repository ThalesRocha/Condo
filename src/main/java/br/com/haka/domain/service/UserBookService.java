package br.com.haka.domain.service;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import br.com.haka.domain.valueObject.BookableAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 26/12/16
 */

@Service
public class UserBookService {


    @Autowired
    private Users users;
    @Deprecated
    //TODO Create a real method of validate the book area
    public Boolean bookArea(Date date, BookableAreas bookableArea, User user) {
        if(user.getUnlocked())
        return true;
        else
          return false;
    }
}
