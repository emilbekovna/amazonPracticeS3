package com.example.demodemoamazons3.repositories;

import com.example.demodemoamazons3.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {

}
