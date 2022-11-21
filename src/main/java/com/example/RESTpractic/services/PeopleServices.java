package com.example.RESTpractic.services;

import com.example.RESTpractic.model.Person;
import com.example.RESTpractic.repositorys.PeopleRepository;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleServices {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServices(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public List<Person> findAll(){
        return peopleRepository.findAll();
    }
    public Person findOne(int id){
        Optional<Person> foundedPerson = peopleRepository.findById(id);
        return foundedPerson.orElse(null);
    }
    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

}
