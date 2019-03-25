package com.ms.aventure.repository;

import com.ms.aventure.entity.Aventure;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AventureRepository extends JpaRepository<Aventure, Integer> {

    List<Aventure> findAllByCategoryId(@Param("categoryId")Integer categoryId);


}
