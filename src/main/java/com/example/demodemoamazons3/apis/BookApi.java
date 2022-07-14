package com.example.demodemoamazons3.apis;

import com.example.demodemoamazons3.dto.book.BookRequest;
import com.example.demodemoamazons3.dto.book.BookResponse;
import com.example.demodemoamazons3.dto.SimpleResponse;
import com.example.demodemoamazons3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
@RequiredArgsConstructor
public class BookApi {
    private final BookService bookService;

    //find all
    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    //find by id
    @PostMapping("/find/{bookId}")
    public BookResponse findById(@PathVariable Long bookId) {
        return bookService.findById(bookId);
    }


    //save
    @PostMapping
    public BookResponse save(@RequestBody BookRequest bookSaveRequest) {
        return bookService.save(bookSaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{bookId}")
    public SimpleResponse deleteBookById(@PathVariable Long bookId) {
        return bookService.deleteById(bookId);
    }

    //update
    @PutMapping("/update/{bookId}")
    public BookResponse updateStudentById(@PathVariable Long bookId,
                                          @RequestBody BookRequest bookSaveRequest) {
        return bookService.updateById(bookId,bookSaveRequest);
    }

}
