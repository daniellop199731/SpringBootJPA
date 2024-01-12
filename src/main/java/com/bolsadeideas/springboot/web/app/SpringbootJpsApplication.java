package com.bolsadeideas.springboot.web.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		List<Person> persons = new ArrayList<Person>();
		List<Object[]> personsOb = new ArrayList<Object[]>();
		Person personOb = new Person();
		Optional<Person> optionalPerson = null;
		
		System.out.println("De vuelve todas las personas");
		persons = (List<Person>) personRepository.findAll();
		persons.stream().forEach(person -> {
			System.out.println(person);
		});
		System.out.println("--------------------------------------");
		System.out.println("De vuelve todas las personas por lenguaje de programacion op 1");
		persons = (List<Person>) personRepository.findByProgrammingLanguage("JavaScript");
		persons.stream().forEach(person ->{
			System.out.println(person);
		});
		System.out.println("--------------------------------------");
		System.out.println("De vuelve todas las personas por lenguaje de programacion op 2");
		persons = (List<Person>) personRepository.buscarPorLenguajeDeProgramacion("Java");
		persons.stream().forEach(person -> {
			System.out.println(person);
		});
		System.out.println("--------------------------------------");
		System.out.println("De vuelve todas las personas por lenguaje de programacion op 3 dos preguntas");
		persons = (List<Person>) personRepository.buscarPorLenguajeDeProgramacion2("Java", "Daniel");
		persons.stream().forEach(person -> {
			System.out.println(person);
		});
		System.out.println("--------------------------------------");
		System.out.println("Optiene campos separados y valores del objeto entity");
		personsOb = (List<Object[]>) personRepository.buscarPorLenguajeDeProgramacion3("Lopez");
		personsOb.stream().forEach(person->{
			System.out.println(person[0] + " es experto en " + person[1]);			
		});
		System.out.println("--------------------------------------");
		System.out.println("Optiene un solo objeto por id");
		personOb = personRepository.findById((long) 1040755874).get();
		System.out.println(personOb);
		
		System.out.println("--------------------------------------");
		System.out.println("Optiene un solo objeto por id (Mejor forma de usar el Optional)");
		long id = 1040755874;
		optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			personOb = optionalPerson.get();
			System.out.println(personOb);	
		} else {
			System.out.println("No existe la person con el id " + id);
		}
		//El sigiente codigo hace lo mismo que las lineas anteriores solo que de una manera mas resumida (hay que consultar como se hace el else)
		//personRepository.findById(id).ifPresent(person -> System.out.println(person));
		//personRepository.findById(id).ifPresent(System.out::println);
			
	}

}
