package com.nimapInfotech.task.repositories;

import com.nimapInfotech.task.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
