package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{


}
