package com.example.demo.repository;

import java.util.List;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Cacheable(value = "findByPesel")
    public List<Person> findByPesel(String pesel);
}
