package com.example.demodemoamazons3.service;


import com.example.demodemoamazons3.dto.SimpleResponse;
import com.example.demodemoamazons3.dto.book.BookRequest;
import com.example.demodemoamazons3.dto.book.BookResponse;
import com.example.demodemoamazons3.exceptions.BookNotFoundException;
import com.example.demodemoamazons3.mapper.book.BookEditMapper;
import com.example.demodemoamazons3.mapper.book.BookViewMapper;
import com.example.demodemoamazons3.models.Book;
import com.example.demodemoamazons3.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookEditMapper bookEditMapper;
    private final BookViewMapper bookViewMapper;

    //find all
    public List<BookResponse> findAll() {
        return bookViewMapper.view(bookRepository.findAll());
    }

    //findById
    public BookResponse findById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new BookNotFoundException("My Exception: Couldn't not fount book!")
        );
        return bookViewMapper.viewBook(book);
    }

    //save
    public BookResponse save(BookRequest bookRequest) {
        Book book = bookEditMapper.create(bookRequest);
        bookRepository.save(book);
        return bookViewMapper.viewBook(book);
    }

    //delete
    public SimpleResponse deleteById(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);

        if (!exists) {
            throw new BookNotFoundException("My Exception: Couldn't not fount company!");
        }

        bookRepository.deleteById(bookId);

        return new SimpleResponse(
                "DELETED",
                "Successfully delete company!"
        );
    }

    //    update
    public BookResponse updateById(Long bookId, BookRequest bookRequest) {
        Book book = bookRepository.findById(bookId).get();
        bookEditMapper.update(book,bookRequest);
        bookRepository.save(book);
        return bookViewMapper.viewBook(bookRepository.save(book));
    }
}
