package com.ex.Dao;

import com.ex.Objects.Lists;
import com.ex.Objects.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface listsDao extends JpaRepository<Lists, Integer> {

}
