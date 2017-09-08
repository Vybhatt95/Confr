package com.ex.Dao;

import com.ex.Objects.Lists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface listsDao extends JpaRepository<Lists, Integer> {
}
