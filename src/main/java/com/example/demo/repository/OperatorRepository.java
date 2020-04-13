package com.example.demo.repository;

import com.example.demo.model.Operator;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperatorRepository extends BaseRepository<Operator, Long> {

    Optional<Operator> findOneByEmail(String email);
}
