package com.example.userApp.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.userApp.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByCountry(String country);
    List<Person> findByCountryAndState(String country, String state);
    List<Person> findByCountryAndStateAndDistrict(String country, String state, String district);
}
