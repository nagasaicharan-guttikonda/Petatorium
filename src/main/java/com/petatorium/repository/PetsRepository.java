package com.petatorium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petatorium.model.Pets;
@Repository
public interface PetsRepository extends JpaRepository<Pets, Integer> {

}
