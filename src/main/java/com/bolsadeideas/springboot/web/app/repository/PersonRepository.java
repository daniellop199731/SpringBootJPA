package com.bolsadeideas.springboot.web.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.web.app.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
