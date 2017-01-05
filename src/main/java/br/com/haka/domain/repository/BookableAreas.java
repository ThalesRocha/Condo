package br.com.haka.domain.repository;

import br.com.haka.domain.entity.BookableArea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hivisonmoura on 2017-01-03.
 */
@Repository
public class BookableAreas {

    private static List<BookableArea> bookableAreas;

    public BookableAreas(){
        this.bookableAreas = new ArrayList<BookableArea>();
    }

    public boolean add(BookableArea bookableArea){
        return this.bookableAreas.add(bookableArea);
    }

    public BookableArea findByName(String name){
        if (name != null){
            for (BookableArea bookableArea :this.bookableAreas){
                if (bookableArea.equals(bookableArea))
                    return bookableArea;
            }
        }
        return null;
    }
}
