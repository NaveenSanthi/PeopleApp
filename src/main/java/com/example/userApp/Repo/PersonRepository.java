package com.example.userApp.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.userApp.Entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCountryContainingIgnoreCaseAndStateContainingIgnoreCaseAndDistrictContainingIgnoreCase(
        String country, String state, String district
    );
}
