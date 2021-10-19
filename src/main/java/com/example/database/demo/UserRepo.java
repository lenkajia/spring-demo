
package com.example.database.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u")
    List<User> getAllUsers();

    @Query(value = "SELECT u FROM User u WHERE u.groupid = ?1")
    List<User> getUsersByGroup(String groupId);

}
