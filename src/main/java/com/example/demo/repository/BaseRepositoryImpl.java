package com.example.demo.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

import java.io.Serializable;
import java.util.Optional;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Optional<T> findOneOptional(ID id) {
        return Optional.ofNullable(findOne(id));
    }

    @Override
    public T findOne(ID id) {
        return findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) {
        deleteById(id);
    }

}
