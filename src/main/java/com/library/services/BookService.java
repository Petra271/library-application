package com.library.services;

import com.library.domain.dtos.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    boolean isExists(String isbn);

    BookDto createUpdateBook(String isbn, BookDto bookDto);

    BookDto partialUpdate(String isbn, BookDto bookDto);

    List<BookDto> findAll();

    Optional<BookDto> findOne(String isbn);

    void delete(String isbn);
}
