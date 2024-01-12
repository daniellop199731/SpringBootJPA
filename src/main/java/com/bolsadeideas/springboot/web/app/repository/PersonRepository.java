package com.bolsadeideas.springboot.web.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.web.app.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{	
	
	List<Person> findByProgrammingLanguage(String programmingLanguage);
	
	@Query("select p  from Person p where p.programmingLanguage=?1")
	List<Person> buscarPorLenguajeDeProgramacion(String programmingLanguage);
	
	@Query("select p  from Person p where p.programmingLanguage=?1 and p.name=?2")
	List<Person> buscarPorLenguajeDeProgramacion2(String programmingLanguage, String name);
	
	@Query("select p.name, p.programmingLanguage from Person p where p.lastname=?1")
	List<Object[]> buscarPorLenguajeDeProgramacion3(String lastname);

}
