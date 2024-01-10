package com.bolsadeideas.springboot.web.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsadeideas.springboot.web.app.entities.Person;
import com.bolsadeideas.springboot.web.app.repository.PersonRepository;

@SpringBootApplication
public class SpringbootJpsApplication implements CommandLineRunner {
	
	//Se ineyta el PersonRepository
	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Person> persons = (List<Person>) personRepository.findAll();
		
		persons.stream().forEach(person -> {
			System.out.println(person);
		});
		
	}

}
