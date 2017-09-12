package com.ex.Dao;

import com.ex.Objects.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userdao extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
