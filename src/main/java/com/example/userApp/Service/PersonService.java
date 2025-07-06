package com.example.userApp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userApp.Entity.Person;
import com.example.userApp.Repo.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPeople(String country, String state, String district) {
        if (country != null && state != null && district != null) {
            return repository.findByCountryAndStateAndDistrict(country, state, district);
        } else if (country != null && state != null) {
            return repository.findByCountryAndState(country, state);
        } else if (country != null) {
            return repository.findByCountry(country);
        } else {
            return repository.findAll();
        }
    }

    public List<Person> updatePeople(List<Person> people) {
        return repository.saveAll(people);
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}