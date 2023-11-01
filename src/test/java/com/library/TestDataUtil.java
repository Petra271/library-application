package com.library;

import com.library.domain.dtos.AuthorDto;
import com.library.domain.dtos.BookDto;
import com.library.domain.entities.AuthorEntity;
import com.library.domain.entities.BookEntity;

public final class TestDataUtil {
    private TestDataUtil(){
    }

    public static AuthorEntity createTestAuthorEntityA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("Stephen King")
                .age(80)
                .build();
    }

    public static AuthorDto createTestAuthorDtoA() {
        return AuthorDto.builder()
                .id(1L)
                .name("Stephen King")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("Jane Austen")
                .age(80)
                .build();
    }

    public static AuthorEntity createTestAuthorC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("Mark Twain")
                .age(24)
                .build();
    }

    public static BookEntity createTestBookA(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("302-300")
                .title("The Green Mile")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("302-300")
                .title("The Green Mile")
                .author(authorDto)
                .build();
    }

    public static BookEntity createTestBookB(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("123-123")
                .title("Pride and Prejudice")
                .authorEntity(authorEntity)
                .build();
    }

    public static BookEntity createTestBookEntityC(final AuthorEntity authorEntity) {
        return BookEntity.builder()
                .isbn("200-123")
                .title("The Adventures of Huckleberry Finn")
                .authorEntity(authorEntity)
                .build();
    }
}