package com.nimapInfotech.task.repositories;

import com.nimapInfotech.task.entities.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatagoryRepo extends JpaRepository<Catagory,Integer> {
    public Optional<Catagory> findByCatagoryName(String name);
}
