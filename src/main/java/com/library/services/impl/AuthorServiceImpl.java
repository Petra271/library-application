package com.library.services.impl;

import com.library.domain.dtos.AuthorDto;
import com.library.domain.entities.AuthorEntity;
import com.library.mappers.Mapper;
import com.library.repositories.AuthorRepository;
import com.library.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final Mapper<AuthorEntity, AuthorDto> authorMapper;

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(Mapper<AuthorEntity, AuthorDto> authorMapper, AuthorRepository authorRepository) {
        this.authorMapper = authorMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto save(AuthorDto author) {
        AuthorEntity authorEntity = authorMapper.mapFrom(author);
        return authorMapper.mapTo(authorRepository.save(authorEntity));
    }

    @Override
    public List<AuthorDto> findAll() {
        return StreamSupport.stream(authorRepository
                .findAll()
                .spliterator()
                , false)
                .map(authorMapper::mapTo)
                .toList();
    }

    @Override
    public Optional<AuthorDto> findOne(Long id) {
        Optional<AuthorEntity> authorEntity = authorRepository.findById(id);
        return authorEntity.map(authorMapper::mapTo);
    }

    @Override
    public boolean isExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorDto partialUpdate(Long id, AuthorDto authorDto) {
        authorDto.setId(id);

        return authorMapper.mapTo(authorRepository.findById(id).map(existingAuthor -> {
            Optional.ofNullable(authorDto.getName()).ifPresent(existingAuthor::setName);
            Optional.ofNullable(authorDto.getAge()).ifPresent(existingAuthor::setAge);
            return authorRepository.save(existingAuthor);
        }).orElseThrow(() -> new RuntimeException("Author does not exist")));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}