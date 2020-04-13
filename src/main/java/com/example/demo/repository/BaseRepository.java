package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    Optional<T> findOneOptional(ID id);

    T findOne(ID id);

    T getOne(ID id);

    void delete(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageabe);
}
