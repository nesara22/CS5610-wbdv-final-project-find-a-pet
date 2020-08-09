package edu.northeastern.cs5610.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import edu.northeastern.cs5610.daos.PetFinderDao;
import edu.northeastern.cs5610.models.Adoption;
import edu.northeastern.cs5610.models.Favorites;
import edu.northeastern.cs5610.models.Following;
import edu.northeastern.cs5610.models.Pet;
import edu.northeastern.cs5610.models.User;

@RestController
public class Controller {

  @Autowired
  PetFinderDao petFinderDao;

  @CrossOrigin
  @GetMapping("/api/pet/{id}")
  public Pet findPetById(@PathVariable("id") int id) {
    return petFinderDao.findPetById(id);
  }
  @CrossOrigin
  @GetMapping("/api/pets")
  public List<Pet> findAllPets() {
    return petFinderDao.findAllPets();
  }
  @CrossOrigin
  @PostMapping("/api/pet")
  public Pet createPet(@RequestBody Pet pet) {
    return petFinderDao.createPet(pet);
  }

  /*
  Update a pet whose user id is specified
   */
  @CrossOrigin
  @PutMapping("/api/updatePet/{id}")
  public Pet updatePet(
          @PathVariable("id") int id,
          @RequestBody Pet newPet
  ) {
    return petFinderDao.updatePet(id, newPet);
  }

  /*
  Deletes the pet whose id is specified
   */
  @CrossOrigin
  @DeleteMapping(value = "/api/delete_pet/{petId}")
  public void deletePet(@PathVariable int petId) {
    petFinderDao.deletePet(petId);
  }


  @CrossOrigin
  @GetMapping("/api/user/{id}")
  public User findUserById(@PathVariable("id") int id) {
    return petFinderDao.findUserById(id);
  }

  @CrossOrigin
  @GetMapping("/api/username/{username}")
  public User findUserByUsername(@PathVariable("username") String username) {
    return petFinderDao.findUserByUsername(username);
  }

  @CrossOrigin
  @GetMapping("/api/users")
  public List<User> findAllCustomers() {
    return petFinderDao.findAllUsers();
  }

  @CrossOrigin
  @GetMapping("/api/credentials/{username}/{password}")
  public boolean findUserByCredentials(@PathVariable("username") String username,
                                       @PathVariable("password") String password) {
    return petFinderDao.findUserByCredentials(username, password);
  }

  /*
  Checks if username is already in use. Returns true if already exists
   */
  @CrossOrigin
  @GetMapping("/api/usernameAvailability/{username}")
  public boolean findUsernameAvailability(@PathVariable("username") String username) {
    return petFinderDao.findUsernameAvailability(username);
  }

  @CrossOrigin
  @PostMapping("api/auth")
  public User findUser(@RequestBody User user) {
    return petFinderDao.findUser(user.getUsername(), user.getPassword());
  }

  @CrossOrigin
  @PostMapping("/api/user")
  public User createUser(@RequestBody User user) {
    return petFinderDao.createUser(user);
  }

  /*
  Update a user whose user id is specified
   */
  @CrossOrigin
  @PutMapping("/api/updateUser/{id}")
  public User updateUser(
          @PathVariable("id") int id,
          @RequestBody User newUser
  ) {
    return petFinderDao.updateUser(id, newUser);
  }

  /*
  Deletes the user whose id is specified
   */
  @CrossOrigin
  @DeleteMapping(value = "/api/delete_user/{userId}")
  public void deleteUser(@PathVariable int userId) {
    petFinderDao.deleteUser(userId);
  }

  /*
  Retrieve 5 last updated users
   */
  @CrossOrigin
  @GetMapping("/api/last_updated_users")
  public List<User> findFiveLastUpdated() {
    return petFinderDao.findFiveLastUpdatedUsers();
  }

  /*
Retrieve all adoption requests
 */
  @CrossOrigin
  @GetMapping("/api/adoption_requests")
  public List<Adoption> findAllAdoptions() {
    return petFinderDao.findAllAdoptions();
  }

  /*
  To create an adoption record in the adoption table. If status is not specified, it's in review by default
   */
  @CrossOrigin
  @PostMapping("/api/adoption")
  public Adoption createAdoption(@RequestBody Adoption adoption) {
    return petFinderDao.createAdoption(adoption);
  }


  /*
  Find the adopted pets for a username (approved requests only)
  Returns list of approved adopted pets' ids.
   */
  @CrossOrigin
  @GetMapping("/api/approved_adoptions/{username}")
  public List<Integer> findApprovedAdoptions(@PathVariable("username") String username) {
    return petFinderDao.findApprovedAdoptedPetsForUsername(username);
  }

  /*
  Find all requests of a user - approved, in review, denied
   */
  @CrossOrigin
  @GetMapping("/api/all_adoption_requests/{username}")
  public List<Adoption> findAllAdoptionRequestsForUsername(@PathVariable("username") String username) {
    return petFinderDao.findAllAdoptionRequestsForUsername(username);
  }

  /*
Find all requests of a user - approved, in review, denied
 */
  @CrossOrigin
  @GetMapping("/api/adoption_request_info/{petId}/{userId}")
  public Adoption findAdoptionRequestInfo(@PathVariable("petId") String petId,
                                                          @PathVariable("userId") int userId) {
    return petFinderDao.findAdoptionRequestInfo(petId,userId);
  }

  /*
Returns adoption objects of recent 5 adopted pets
 */
  @CrossOrigin
  @GetMapping("/api/recently_adopted")
  public List<Adoption> findLastFiveAdoptedPets() {
    return petFinderDao.findLastFiveAdoptedPets();
  }

  /*
  Returns true if the pet is NOT adopted (pet is available for adoption), false if pet is adopted
   */
  @CrossOrigin
  @GetMapping("/api/pet_availability/{petId}")
  public boolean findPetAvailability(@PathVariable("petId") String petId) {
    return petFinderDao.findPetAvailability(petId);
  }

  /*
  Returns true if deletion is successful.
   */
  @CrossOrigin
  @DeleteMapping(value = "/api/delete_adoption/{userId}/{petId}")
  public boolean deleteAdoptionRequestForUser(@PathVariable int userId,
                                              @PathVariable String petId) {
    return petFinderDao.deleteAdoptionRequestForUser(userId, petId);
  }


  /*
  Decline adoption request
   */
  @CrossOrigin
  @PutMapping("/api/decline_request/{petId}/{userId}")
  public void declineAdoptionRequest(
          @PathVariable("petId") String petId,
          @PathVariable("userId") int userId) {
    petFinderDao.declineAdoptionRequest(petId, userId);
  }



  /*Approve the adoption request*/

  @CrossOrigin
  @PutMapping("/api/approve_adoption/{petId}/{userId}")
  public boolean approveAdoption(
          @PathVariable("petId") String petId,
          @PathVariable("userId") int userId) {
    return petFinderDao.approveAdoptionRequest(petId, userId);
  }

  /*
  Find the favorites of a user
   */
  @CrossOrigin
  @GetMapping("/api/favorites/{userId}")
  public List<Integer> findFavsForUser(@PathVariable("userId") int userId) {
    return petFinderDao.findFavsPetIdForUser(userId);
  }

  /*
  Post a favorite of a user
   */
  @CrossOrigin
  @PostMapping("/api/favorite")
  public Favorites createFavorite(@RequestBody Favorites favorite) {
    return petFinderDao.createFavorite(favorite);
  }

  /*
  Check if pet is a favorite of user. Returns true if it is a favorite, else returns false.
 */
  @CrossOrigin
  @GetMapping("/api/check_favorite/{petId}/{userId}")
  public boolean checkFavorite(@PathVariable("petId") String petId,
                               @PathVariable("userId") int userId) {
    return petFinderDao.checkFavorite(petId, userId);
  }

  /*
Post a following record for a user
 */
  @CrossOrigin
  @PostMapping("/api/following")
  public Following createFollowing(@RequestBody Following following) {
    return petFinderDao.createFollowing(following);
  }

  /*
  retrieve all following records
   */
  @CrossOrigin
  @GetMapping("/api/all_following_records")
  public List<Following> findAllFollowingRecords() {
    return petFinderDao.findAllFollowingRecords();
  }

  /*
retrieve all the people who the user is following
 */
  @CrossOrigin
  @GetMapping("/api/followings_for_user/{userId}")
  public List<User> findFollowingsForUsers(@PathVariable("userId") int userId) {
    return petFinderDao.findFollowingsForUsers(userId);
  }

  ///api/delete_favourite/${userId}/${petId}
  @CrossOrigin
  @DeleteMapping(value = "/api/delete_favourite/{userId}/{petId}")
  public boolean deleteFavourite(@PathVariable int userId,
                                              @PathVariable String petId) {
    return petFinderDao.deleteFavourite(userId, petId);
  }

}
