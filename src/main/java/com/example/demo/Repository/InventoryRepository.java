package com.example.demo.Repository;

import com.example.demo.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
