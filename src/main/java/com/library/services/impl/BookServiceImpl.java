package com.library.services.impl;

import com.library.domain.dtos.BookDto;
import com.library.domain.entities.BookEntity;
import com.library.mappers.Mapper;
import com.library.repositories.BookRepository;
import com.library.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final Mapper<BookEntity, BookDto> bookMapper;

    public BookServiceImpl(BookRepository bookRepository, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean isExists(String isbn) {
        return bookRepository.existsById(isbn);
    }

    @Override
    public BookDto createUpdateBook(String isbn, BookDto bookDto) {
        bookDto.setIsbn(isbn);
        return bookMapper.mapTo(bookRepository.save(bookMapper.mapFrom(bookDto)));
    }

    @Override
    public BookDto partialUpdate(String isbn, BookDto bookDto) {
        bookDto.setIsbn(isbn);
        return bookMapper.mapTo(bookRepository.findById(isbn).map(existingBook -> {
            Optional.ofNullable(bookDto.getTitle()).ifPresent(existingBook::setTitle);
            return bookRepository.save(existingBook);
        }).orElseThrow(() -> new RuntimeException("Book does not exist")));
    }

    @Override
    public List<BookDto> findAll() {
        return StreamSupport.stream(bookRepository
                .findAll()
                .spliterator(),
                false)
                .map(bookMapper::mapTo)
                .toList();
    }

    @Override
    public Optional<BookDto> findOne(String isbn) {
        Optional<BookEntity> bookEntity = bookRepository.findById(isbn);
        return bookEntity.map(bookMapper::mapTo);
    }

    @Override
    public void delete(String isbn) {
        bookRepository.deleteById(isbn);
    }

}
