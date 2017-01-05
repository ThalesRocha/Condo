package br.com.haka.domain.service;

import br.com.haka.domain.entity.BookableArea;
import br.com.haka.domain.repository.BookableAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hivisonmoura on 2017-01-05.
 */
@Service
public class BookableAreaCreatorService {

    @Autowired
    private BookableAreas bookableAreas;



    public BookableArea create(String name, int capacity) {
        BookableArea bookableArea = BookableArea.createBookableArea(name,capacity);
        bookableAreas.add(bookableArea);
        return bookableAreas.findByName(name);
    }

}
