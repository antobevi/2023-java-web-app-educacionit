package com.antobevi.javawebappeducacionit.repository;

import com.antobevi.javawebappeducacionit.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findByName(String name);

    @Query("SELECT p FROM Pet p ORDER BY LOWER(p.name) ASC")
    List<Pet> findAllOrderByNameIgnoreCaseDesc();

    @Query("SELECT p FROM Pet p ORDER BY p.id ASC")
    List<Pet> findAllOrderById();

}
