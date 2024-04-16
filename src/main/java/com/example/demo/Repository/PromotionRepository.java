package com.example.demo.Repository;

import com.example.demo.models.Promotion;
import org.springframework.data.repository.CrudRepository;

public interface PromotionRepository extends CrudRepository<Promotion, Integer> {
}
