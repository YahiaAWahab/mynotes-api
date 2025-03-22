package com.example.mynotes.repository;

import com.example.mynotes.model.AppUser;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository  extends CrudRepository<AppUser, String> {

    @Modifying
    @Query("INSERT INTO users VALUES (:username , :password , :enabled);")
    boolean createNewUser(@Param("username") String username, @Param("password") String password, @Param("enabled") boolean enabled);

    @Modifying
    @Query("INSERT INTO authorities VALUES (:username, 'user');")
    boolean createNewAuthority(@Param("username") String username);

    @Query("SELECT * FROM users WHERE username LIKE :username LIMIT 1")
    AppUser lookupUsername(@Param("username") String username);

}
