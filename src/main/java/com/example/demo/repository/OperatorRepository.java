package com.example.demo.repository;

import com.example.demo.model.Operator;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends BaseRepository<Operator, Long> {
}
