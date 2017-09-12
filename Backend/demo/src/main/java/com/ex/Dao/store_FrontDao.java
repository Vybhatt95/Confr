package com.ex.Dao;

import com.ex.Objects.Store_Front;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface store_frontDao extends JpaRepository<Store_Front, Integer> {
}
