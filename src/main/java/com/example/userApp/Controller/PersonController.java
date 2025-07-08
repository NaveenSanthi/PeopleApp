package com.example.userApp.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userApp.Entity.Person;
import com.example.userApp.Service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    // 1. Filter API
    @PostMapping("/filter")
    public List<Person> filter(@RequestBody Map<String, String> request) {
        String country = request.get("country");
        String state = request.get("state");
        String district = request.get("district");
        return service.filterPersons(country, state, district);
    }

    // 2. Save API
    @PostMapping("/saveAll")
    public String saveAll(@RequestBody List<Person> people) {
        return service.saveAll(people);
    }

    // 3. Delete API
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteById(id);
    }
    
    @GetMapping("/addDummy")
    public String addDummyData() {
        Person p1 = new Person();
        p1.setName("John Doe");
        p1.setAge(30);
        p1.setSex("Male");
        p1.setCountry("USA");
        p1.setState("California");
        p1.setDistrict("Los Angeles");

        Person p2 = new Person();
        p2.setName("Jane Smith");
        p2.setAge(28);
        p2.setSex("Female");
        p2.setCountry("India");
        p2.setState("Tamil Nadu");
        p2.setDistrict("Chennai");

        service.savePerson(p1);
        service.savePerson(p2);
        return "record added";
}
}