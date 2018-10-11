package com.rohan.festapp.users.repository;

import com.rohan.festapp.users.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    public User findByToken(String token);
}
