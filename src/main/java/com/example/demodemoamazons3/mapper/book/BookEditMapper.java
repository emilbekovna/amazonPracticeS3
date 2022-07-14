package com.example.demodemoamazons3.mapper.book;
import com.example.demodemoamazons3.dto.book.BookRequest;
import com.example.demodemoamazons3.models.Book;
import org.springframework.stereotype.Component;


@Component
public class BookEditMapper {

    public Book create(BookRequest request) {

        if(request == null) {
            return null;
        }

        Book book = new Book();
        book.setName(request.getName());
        book.setFragment(request.getFragment());

        return book;
    }

    public void update(Book book, BookRequest request) {
        book.setName(request.getName());
        book.setFragment(request.getFragment());
    }
}
