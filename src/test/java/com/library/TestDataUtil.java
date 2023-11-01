package com.library;

import com.library.domain.dtos.AuthorDto;
import com.library.domain.dtos.BookDto;
import com.library.domain.entities.AuthorEntity;

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

    public static BookDto createTestBookDtoA(final AuthorDto authorDto) {
        return BookDto.builder()
                .isbn("302-300")
                .title("The Green Mile")
                .author(authorDto)
                .build();
    }
}