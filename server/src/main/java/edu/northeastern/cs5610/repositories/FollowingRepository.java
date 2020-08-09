package edu.northeastern.cs5610.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import edu.northeastern.cs5610.models.Following;

public interface FollowingRepository extends CrudRepository<Following, Integer> {

  //findFollowingsForUsers

  @Query("SELECT f.followingId FROM Following f where f.follower.id=:followerId")
  List<Integer> findFollowingsForUsers(@Param("followerId") int followerId);

  @Transactional
  @Modifying
  @Query("DELETE from Following f where f.followingId=:followingId")
  void deleteUserInFollowing(@Param("followingId") int followingId);

}
