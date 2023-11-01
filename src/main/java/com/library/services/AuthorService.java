package com.library.services;

import com.library.domain.dtos.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorDto save(AuthorDto author);

    List<AuthorDto> findAll();

    Optional<AuthorDto> findOne(Long id);

    boolean isExists(Long id);

    AuthorDto partialUpdate(Long id, AuthorDto authorDto);

    void delete(Long id);
}
