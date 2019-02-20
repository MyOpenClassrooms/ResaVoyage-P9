package com.ms.aventure.repository;

import com.ms.aventure.entity.Aventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AventureRepository extends JpaRepository<Aventure, Integer> {

}
