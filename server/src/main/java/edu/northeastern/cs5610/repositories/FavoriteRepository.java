package edu.northeastern.cs5610.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import edu.northeastern.cs5610.models.Favorites;

public interface FavoriteRepository extends CrudRepository<Favorites, Integer> {
  @Query("SELECT f.petId from Favorites f where f.user.id=:userId")
  List<Integer> findFavsPetIdForUser(@Param("userId") int userId);

  @Query("SELECT f from Favorites f where f.user.id=:userId and f.petId=:petId")
  Favorites checkFavorite(@Param("petId") String petId,
                          @Param("userId") int userId);

  //deleteFavourite
  @Transactional
  @Modifying
  @Query("DELETE from Favorites f where f.user.id=:userId and f.petId=:petId")
  void deleteFavourite(@Param("userId") int userId,
                       @Param("petId") String petId);

  @Transactional
  @Modifying
  @Query("DELETE from Favorites f where f.user.id=:userId")
  void deleteAllFavouriteForUser(@Param("userId") int userId);


}
