package edu.northeastern.cs5610.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import edu.northeastern.cs5610.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {
  @Transactional
  @Modifying
  @Query("DELETE from Pet p where p.id=:id")
  void deletePet(@Param("id") int id);
}
