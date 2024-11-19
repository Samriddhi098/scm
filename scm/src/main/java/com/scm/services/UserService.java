package com.scm.services;
import com.scm.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
User saveuser(User user);
Optional<User> getUserById(String id);
//it is a classs tht used as to check if the info is there or not 
Optional<User> updateUser(User user);
void deleteUser(String id);
boolean isUserExist(String userId);
boolean isUserExistByUserName(String email);

List<User> getAllUsers();
//add more method related to user service
}
