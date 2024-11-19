package com.scm.services.imple;

import java.util.List;
import java.util.Optional;

// import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scm.entities.User;
import com.scm.helper.resourceNotFoundException;
import com.scm.repositories.Repo;
import com.scm.services.UserService;
import java.util.*;
@Controller
public class UserServiceImple implements UserService{

    @Autowired
    // @Lazy

    private Repo repo;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveuser(User user) {
        //user id: have to generate it
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        //password encode
        //user.setPassword(userId);
      
       return repo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
       return repo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
     User user1= repo.findById(user.getUserId()).orElseThrow(()->new resourceNotFoundException("user not found"));
    //update the user1 form user
    user1.setName(user.getName());
    user1.setEmail(user.getEmail());
    user1.setPassword(user.getPassword());
    user1.setAbout(user.getAbout());
    user1.setPhonenumber(user.getPhonenumber());
    user1.setProfilepic(user.getProfilepic());
    user1.setEnabled(user.isEnabled());
    user1.setEmailverified(user.isEmailverified());
    user1.setPhoneverified(user.isPhoneverified());
    user1.setProvideruserid(user.getProvideruserid());
    //save the user in db
    User save= repo.save(user1);
    
    return Optional.ofNullable(save);
}

    @Override
    public void deleteUser(String id) {
        User user1= repo.findById(id)
        .orElseThrow(()->new resourceNotFoundException("user not found"));
     repo.delete(user1);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user1= repo.findById(userId)
        .orElse(null);
        return user1!=null ?true:false;
    }

    @Override
    public boolean isUserExistByUserName(String email) {
       User user=repo.findByEmail(email).orElse(null);
       return user!=null ?true:false;
    }

    @Override
    public List<User> getAllUsers() {
      return repo.findAll();
    }

}
