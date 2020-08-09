package edu.northeastern.cs5610.daos;

import java.util.List;

import edu.northeastern.cs5610.models.Adoption;
import edu.northeastern.cs5610.models.Favorites;
import edu.northeastern.cs5610.models.Following;
import edu.northeastern.cs5610.models.Pet;
import edu.northeastern.cs5610.models.User;

public interface PetFinderDao {

/*  public static PetFinderDao getInstance() {
    PetFinderDao instance = null;
    if (instance == null)
      instance = new PetFinderDaoImpl();
    return instance;
  }*/


  User createUser(User user);

  User findUserById(int uid);

  User findUserByUsername(String username);

  List<User> findAllUsers();

  List<Adoption> findAllAdoptions();

  boolean findUserByCredentials(String username, String password);

  boolean findUsernameAvailability(String username);

  User updateUser(int id, User user);

  User findUser(String username, String password);

  List<User> findFiveLastUpdatedUsers();

  Adoption createAdoption(Adoption adoption);

  List<Integer> findApprovedAdoptedPetsForUsername(String username);

  List<Adoption> findAllAdoptionRequestsForUsername(String username);

  void declineAdoptionRequest(String petId, int userId);

  boolean approveAdoptionRequest(String petId, int userId);

  List<Integer> findFavsPetIdForUser(int username);

  Favorites createFavorite(Favorites favorite);

  List<Adoption> findLastFiveAdoptedPets();

  void deleteUser(int id);

  boolean deleteAdoptionRequestForUser(int userId, String petId);

  boolean findPetAvailability(String petId);

  boolean checkFavorite(String petId, int userId);

  Following createFollowing(Following following);

  List<Following> findAllFollowingRecords();

  List<User> findFollowingsForUsers(int userId);

  Adoption findAdoptionRequestInfo(String petId, int userId);

  boolean deleteFavourite(int userId, String petId);

  Pet findPetById(int petId);

  List<Pet> findAllPets();

  Pet createPet(Pet pet);

  Pet updatePet(int id, Pet newPet);

  void deletePet(int id);
}
