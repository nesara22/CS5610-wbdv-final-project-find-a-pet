package edu.northeastern.cs5610.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import edu.northeastern.cs5610.models.Adoption;

public interface AdoptionRepository extends CrudRepository<Adoption, Integer> {


  @Query("SELECT a from Adoption a where a.user.username=:username")
  List<Adoption> findAllAdoptionRequestsForUsername(@Param("username") String username);


  @Query("SELECT a.petId from Adoption a where a.user.username=:username and a.status='0'")
  List<Integer> findApprovedAdoptedPetsForUsername(@Param("username") String username);

  @Query("SELECT a from Adoption a where a.status='0' order by a.lastUpdated desc")
  List<Adoption> findLastFiveAdoptedPets();

  @Query("SELECT a from Adoption a where a.status='0' and a.petId=:petId")
  Adoption findPetAvailability(@Param("petId") String petId);

  @Query("SELECT a from Adoption a where a.user.id=:userId and a.petId=:petId")
  Adoption findAdoptionRequestEntry(@Param("petId") String petId,
                                    @Param("userId") int userId);

  @Query("SELECT a from Adoption a where a.user.id=:userId and a.petId=:petId and a.status='0'")
  Adoption findAdoptionApproval(@Param("petId") String petId,
                                    @Param("userId") int userId);


  @Transactional
  @Modifying
  @Query("UPDATE Adoption a SET a.status='1' where a.petId=:petId and a.user.id=:userId")
  void declineAdoptionRequest(@Param("petId") String petId,
                              @Param("userId") int userId);

  @Transactional
  @Modifying
  @Query("UPDATE Adoption a SET a.status='0' where a.petId=:petId and a.user.id=:userId")
  void approveAdoptionRequest(@Param("petId") String petId,
                              @Param("userId") int userId);

  @Transactional
  @Modifying
  @Query("UPDATE Adoption a SET a.status='1' where a.petId=:petId and a.status='2'")
  void declineAdoptionRequestForPetAfterApproval(@Param("petId") String petId);

  @Transactional
  @Modifying
  @Query("DELETE from Adoption a where a.status='2' and a.user.id=:userId and a.petId=:petId")
  void deleteAdoptionRequestForUser(@Param("userId") int userId,
                                    @Param("petId") String petId);


  @Transactional
  @Modifying
  @Query("DELETE from Adoption a where a.user.id=:userId")
  void deleteAllAdoptionRequestForUser(@Param("userId") int userId);


}
