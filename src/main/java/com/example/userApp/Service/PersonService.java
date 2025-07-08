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

    public List<Person> filterPersons(String country, String state, String district) {
        return repository.findByCountryContainingIgnoreCaseAndStateContainingIgnoreCaseAndDistrictContainingIgnoreCase(
            country == null ? "" : country,
            state == null ? "" : state,
            district == null ? "" : district
        );
    }

    public String saveAll(List<Person> people) {
        try {
            repository.saveAll(people);
            return "Saved successfully";
        } catch (Exception e) {
            return "Error saving data: " + e.getMessage();
        }
    }

    public String deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted successfully";
        } else {
            return "Record not found";
        }
    }
}