package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path="/person") 
public class PersonController {

    @Autowired
    private PersonRepo personRepo; 

    @GetMapping("/all")
    public @ResponseBody Iterable<Person> getAll(){
        return personRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Optional<Person> getOne(@PathVariable int id){
        return personRepo.findById(id);
    }

    @PostMapping("/add")
    public @ResponseBody Person add(@RequestBody Person person){
        return personRepo.save(person);
    }

    @PutMapping("/update")
    public @ResponseBody Person update(@RequestBody Person person){
        Optional<Person> tempPerson = getOne(person.getId());

        tempPerson.get().setName(person.getName());
        tempPerson.get().setEmail(person.getEmail());

        return personRepo.save(tempPerson.get());
    }


    
}
