package com.ex.Dao;

import com.ex.Objects.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemDao extends JpaRepository<Item, Integer> {
}
