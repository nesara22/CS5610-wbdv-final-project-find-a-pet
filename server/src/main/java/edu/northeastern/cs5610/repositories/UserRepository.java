package edu.northeastern.cs5610.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import edu.northeastern.cs5610.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

  @Query("SELECT u FROM User u where u.username=:username and u.password=:password")
  User findUserByCredentials(@Param("username") String username, @Param("password") String password);

  @Query("SELECT u FROM User u where u.username=:username and u.password=:password")
  User findUser(@Param("username") String username, @Param("password") String password);

  @Query("SELECT u from User u where u.username=:username")
  User findUserByUsername(@Param("username") String username);

  //findUserById
  @Query("SELECT u from User u where u.id=:id")
  User findUserById(@Param("id") int id);

  @Query("SELECT u from User u order by u.lastUpdated desc ")
  List<User> findFiveLastUpdatedUsers();

  @Transactional
  @Modifying
  @Query("DELETE from User u where u.id=:id")
  void deleteUser(@Param("id") int id);

}
