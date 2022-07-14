package com.example.demodemoamazons3.mapper.book;


import com.example.demodemoamazons3.dto.book.BookResponse;
import com.example.demodemoamazons3.models.Book;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class BookViewMapper {

    public BookResponse viewBook(Book book) {
        if (book == null) {
            return null;
        }

        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setName(book.getName());

        return response;
    }

    public List<BookResponse> view(List<Book> books) {
        List<BookResponse> responses = new ArrayList<>();
        for (Book book : books) {
            responses.add(viewBook(book));
        }
        return responses;
    }
}
