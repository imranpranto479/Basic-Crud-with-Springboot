package com.imranpranto.main.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imranpranto.main.springmvc.model.Programmer;

@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {

}
