package com.ms.aventure.repository;

import com.ms.aventure.entity.Aventure;
import com.ms.aventure.entity.Session;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AventureRepository extends JpaRepository<Aventure, Integer> {

	
	 //Aventure findAventureBySessionId(Integer sessionId);
}
