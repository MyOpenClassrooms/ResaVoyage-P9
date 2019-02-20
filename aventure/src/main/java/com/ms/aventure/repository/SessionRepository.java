package com.ms.aventure.repository;

import com.ms.aventure.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {


    List<Session> findAllByAventureId(Integer aventureId);



}
