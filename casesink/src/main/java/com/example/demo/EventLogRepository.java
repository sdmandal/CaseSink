package com.example.demo;


import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface EventLogRepository extends CrudRepository<Eventlog, Integer> {
  @Override
  Optional<Eventlog> findById(Integer integer);

}