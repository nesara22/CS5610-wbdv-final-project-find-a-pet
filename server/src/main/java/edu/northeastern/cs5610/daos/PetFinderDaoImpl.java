package edu.northeastern.cs5610.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.northeastern.cs5610.models.Adoption;
import edu.northeastern.cs5610.models.Favorites;
import edu.northeastern.cs5610.models.Following;
import edu.northeastern.cs5610.models.Pet;
import edu.northeastern.cs5610.models.User;
import edu.northeastern.cs5610.repositories.AdoptionRepository;
import edu.northeastern.cs5610.repositories.FavoriteRepository;
import edu.northeastern.cs5610.repositories.FollowingRepository;
import edu.northeastern.cs5610.repositories.PetRepository;
import edu.northeastern.cs5610.repositories.UserRepository;

@Component
public class PetFinderDaoImpl implements PetFinderDao {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AdoptionRepository adoptionRepository;

  @Autowired
  FavoriteRepository favoriteRepository;

  @Autowired
  FollowingRepository followingRepository;

  @Autowired
  PetRepository petRepository;

  @Override
  public Pet findPetById(int pid) {
    return petRepository.findById(pid).get();
  }
  @Override
  public Pet createPet(Pet pet) {
    petRepository.save(pet);
    return pet;
  }

  @Override
  public List<Pet> findAllPets() {
    return (List<Pet>) petRepository.findAll();
  }
  @Override
  public Pet updatePet(int id, Pet newPet) {
    Pet oldPet = petRepository.findById(id).get();
    oldPet.setPetName(newPet.getPetName());
    oldPet.setPetType(newPet.getPetType());
    oldPet.setGender(newPet.getGender());
    oldPet.setPetColor(newPet.getPetColor());
    oldPet.setImageUrl(newPet.getImageUrl());
    petRepository.save(oldPet);
    return oldPet;
  }
  @Override
  public void deletePet(int id) {
    petRepository.deletePet(id);
  }

  @Override
  public User findUserById(int uid) {
    return userRepository.findById(uid).get();
  }

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findUserByUsername(username);
  }
  @Override
  public User createUser(User user) {
    userRepository.save(user);
    return user;
  }

  @Override
  public List<User> findAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public boolean findUserByCredentials(String username, String password) {
    User user = userRepository.findUserByCredentials(username, password);
    return user != null;
  }

  @Override
  public boolean findUsernameAvailability(String username) {
    User user = userRepository.findUserByUsername(username);
    return user != null;
  }

  @Override
  public User updateUser(int id, User newUser) {
    User oldUser = userRepository.findById(id).get();
    oldUser.setFirstName(newUser.getFirstName());
    oldUser.setLastName(newUser.getLastName());
    oldUser.setUsername(newUser.getUsername());
    oldUser.setPassword(newUser.getPassword());
    oldUser.setEmail(newUser.getEmail());
    oldUser.setAddress(newUser.getAddress());
    oldUser.setPhone(newUser.getPhone());
    oldUser.setLastUpdated(System.currentTimeMillis());
    userRepository.save(oldUser);
    return oldUser;
  }

  @Override
  public User findUser(String username, String password) {
    return userRepository.findUser(username, password);
  }

  @Override
  public List<User> findFiveLastUpdatedUsers() {
    List<User> finalUsers = new ArrayList<User>();
    List<User> users = userRepository.findFiveLastUpdatedUsers();
    if (users.size() > 5) {
      for (int i = 0; i < 5; i++) {
        finalUsers.add(users.get(i));
      }
      return finalUsers;
    } else return users;
  }

  @Override
  public Adoption createAdoption(Adoption adoption) {
    adoption.setUserDuplicateId(adoption.user.getId());
    return adoptionRepository.save(adoption);
  }

  @Override
  public List<Integer> findApprovedAdoptedPetsForUsername(String username) {
    return adoptionRepository.findApprovedAdoptedPetsForUsername(username);
  }

  @Override
  public List<Adoption> findAllAdoptionRequestsForUsername(String username) {
    return adoptionRepository.findAllAdoptionRequestsForUsername(username);
  }

  @Override
  public void declineAdoptionRequest(String petId, int userId) {
    adoptionRepository.declineAdoptionRequest(petId, userId);
  }

  @Override
  public boolean approveAdoptionRequest(String petId, int userId) {
    adoptionRepository.approveAdoptionRequest(petId, userId);
    adoptionRepository.declineAdoptionRequestForPetAfterApproval(petId);
    return adoptionRepository.findAdoptionApproval(petId, userId) != null;
  }

  @Override
  public List<Integer> findFavsPetIdForUser(int userId) {
    return favoriteRepository.findFavsPetIdForUser(userId);
  }

  @Override
  public Favorites createFavorite(Favorites favorite) {
    return favoriteRepository.save(favorite);
  }

  @Override
  public List<Adoption> findLastFiveAdoptedPets() {
    List<Adoption> allPetIds = adoptionRepository.findLastFiveAdoptedPets();
    List<Adoption> finalPetIds = new ArrayList<>();
    if (allPetIds.size() > 5) {
      for (int i = 0; i < 5; i++) {
        finalPetIds.add(allPetIds.get(i));
      }
      return finalPetIds;
    } else return allPetIds;
  }

  @Override
  public void deleteUser(int id) {
    userRepository.deleteUser(id);
    followingRepository.deleteUserInFollowing(id);
    adoptionRepository.deleteAllAdoptionRequestForUser(id);
    favoriteRepository.deleteAllFavouriteForUser(id);
  }

  @Override
  public boolean deleteAdoptionRequestForUser(int userId, String petId) {
    adoptionRepository.deleteAdoptionRequestForUser(userId, petId);
    return adoptionRepository.findAdoptionRequestEntry(petId, userId) == null;
  }

  @Override
  public boolean findPetAvailability(String petId) {
    return adoptionRepository.findPetAvailability(petId) == null;
  }

  @Override
  public boolean checkFavorite(String petId, int userId) {
    return favoriteRepository.checkFavorite(petId, userId) != null;
  }

  @Override
  public List<Adoption> findAllAdoptions() {
    return (List<Adoption>) adoptionRepository.findAll();
  }

  @Override
  public Following createFollowing(Following following) {
    following.setFollowerDuplicateId(following.getFollower().getId());
    return followingRepository.save(following);
  }

  @Override
  public List<Following> findAllFollowingRecords() {
    return (List<Following>) followingRepository.findAll();
  }

  @Override
  public List<User> findFollowingsForUsers(int userId) {
    List<Integer> userIds =  followingRepository.findFollowingsForUsers(userId);
    List<User> users = new ArrayList<>();
    for (int id : userIds) {
      users.add(userRepository.findUserById(id));
    }
    return users;
  }

  @Override
  public Adoption findAdoptionRequestInfo(String petId, int userId) {
    return adoptionRepository.findAdoptionRequestEntry(petId,userId);
  }

  @Override
  public boolean deleteFavourite(int userId, String petId) {
    favoriteRepository.deleteFavourite(userId,petId);
    return favoriteRepository.checkFavorite(petId, userId) == null;
  }


}
