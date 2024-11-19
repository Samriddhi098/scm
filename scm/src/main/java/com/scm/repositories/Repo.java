package com.scm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.scm.entities.User;
import java.util.List;
import java.util.Optional;


@Repository
public interface Repo extends JpaRepository<User,String> {
//extra methods db related operations
//custom query methods
//custom finder methods
Optional<User> findByEmail(String email);
Optional<User> findByPassword(String password);
}
