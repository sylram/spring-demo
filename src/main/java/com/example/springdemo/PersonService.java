package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Person readById(Long id){
        return repository.findById(id).get();
    }

    public List<Person> readAll(){
        Iterable<Person> allPeople = repository.findAll();
        List<Person> personList = new ArrayList<>();
        allPeople.forEach(personList::add);
        return personList;
    }

    public Person update(Long id, Person newPersonData){
        Person personInDb = this.readById(id);
        personInDb.setLastName(newPersonData.getLastName());
        personInDb.setFirstName(newPersonData.getFirstName());
        personInDb.setBirthdate(newPersonData.getBirthdate());
        personInDb = repository.save(personInDb);
        return personInDb;
    }


    public Optional<Person> deleteById(Long id){
        Optional<Person> personToBeDeleted = repository.findById(id);
        repository.deleteById(id);
        return personToBeDeleted;
    }
}
