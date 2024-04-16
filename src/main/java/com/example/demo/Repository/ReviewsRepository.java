package com.example.demo.Repository;

import com.example.demo.models.Reviews;
import org.springframework.data.repository.CrudRepository;

public interface ReviewsRepository extends CrudRepository<Reviews, Integer> {
}
