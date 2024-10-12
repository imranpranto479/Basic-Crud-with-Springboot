package com.imranpranto.main.springmvc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imranpranto.main.springmvc.model.Programmer;



@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {

    List<Programmer> findBypLang(String pLang);

    // List<Programmer> findBypName(String pName);


    @Query("from Programmer where pName = ?1")  //customr query
    List<Programmer>findP(String pName);


}
