package com.ex.Dao;

import com.ex.Objects.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jeremy on 9/8/2017.
 */
public interface Userdao extends JpaRepository<User, Integer> {
}
