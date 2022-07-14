package com.example.demodemoamazons3.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id")
    @SequenceGenerator(name="book_id",sequenceName = "book_id_seq",allocationSize = 1)
    private Long id;

    private String name;

    private String fragment;
}
