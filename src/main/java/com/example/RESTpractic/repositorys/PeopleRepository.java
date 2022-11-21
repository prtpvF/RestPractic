package com.example.RESTpractic.repositorys;

import com.example.RESTpractic.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PeopleRepository extends JpaRepository<Person, Integer> {

}