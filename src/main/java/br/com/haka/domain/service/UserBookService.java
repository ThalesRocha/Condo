package br.com.haka.domain.service;

import br.com.haka.domain.entity.User;
import br.com.haka.domain.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.haka.domain.valueObject.*;

/**
 * Created with IntelliJ IDEA.
 * User: Guilherme Bury
 * Date: 26/12/16
 */

@Service
public class UserBookService {

    @Autowired
    private Users users;

    public void bookArea(Date date, BookableArea bookableArea, User user) {

    }
}
